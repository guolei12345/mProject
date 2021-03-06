package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.*;
import cn.edu.nuc.ssm.entity.power.User;
import cn.edu.nuc.ssm.service.interfaces.movie.*;
import cn.edu.nuc.ssm.service.interfaces.util.FileService;
import cn.edu.nuc.ssm.util.*;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/movie")
public class MovieController extends BaseController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FileService fileService;
    @Autowired
    private PicService picService;
    @Autowired
    private ValidateCodeService validateCodeService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private UserScheduleService userScheduleService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getindex(Model model,String url){
        logger.info("to get index");
        List<Type> typeList = typeService.selectAllType();
        List<Movie> movieList = new ArrayList<>();
        for(Type type : typeList){
            movieList = movieService.selectMovieByType(type.getTypeid());
            model.addAttribute(type.getColum2(),movieList);
        }
        //今日热播
        String date = StringUtil.getTodayDate();
        List<Schedule> scheduleListJR = scheduleService.selectScheduleByDate(date);
        List<Movie> movieLists = MovieUtil.getTodayMovieBySchedule(scheduleListJR);
        model.addAttribute("movieList",movieLists);
        model.addAttribute("typeList",typeList);
        model.addAttribute("scheduleListJR",scheduleListJR);
        String returnUrl = "/movie/index";
        if(StringUtil.isNotEmpty(url)){
            returnUrl = "/movie/"+url;
        }
        return returnUrl;
    }
    @RequestMapping(value = "/selectSet",method = RequestMethod.GET)
    public String selectSet(String scheduleid,HttpSession session,Model model){
        logger.info("to get selectSet");
        Schedule schedule = scheduleService.selectByPrimaryKey(scheduleid);
        //今日热播
        String date = StringUtil.getTodayDate();
        List<Schedule> scheduleListJR = scheduleService.selectScheduleByDate(date);
        List<Movie> movieLists = MovieUtil.getTodayMovieBySchedule(scheduleListJR);
        model.addAttribute("movieList",movieLists);
        model.addAttribute("schedule",schedule);
        return "/movie/selectSet";
    }
    @RequestMapping(value = "/videoInfo",method = RequestMethod.GET)
    public String videoInfo(String movieid,HttpSession session,Model model){
        logger.info("to get videoInfo");
        Movie movie = movieService.selectByPrimaryKey(movieid);
        List<Schedule> scheduleList = scheduleService.selectScheduleByMovieId(movieid);
        Map<String,Integer> typeNum = movieService.totalSearchMovieType(session,movie.getTypeid());
        //今日热播
        String date = StringUtil.getTodayDate();
        List<Schedule> scheduleListJR = scheduleService.selectScheduleByDate(date);
        List<Movie> movieLists = MovieUtil.getTodayMovieBySchedule(scheduleListJR);
        model.addAttribute("movieList",movieLists);
        model.addAttribute("scheduleList",scheduleList);
        model.addAttribute("movie",movie);
        session.setAttribute("typeNum",typeNum);
        return "/movie/videoInfo";
    }
    /**
     * 电影票信息查询
     * @return
     */
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    public String deleteOrder(String userScheduleId,HttpSession session,Model model){
        logger.info("to get deleteOrder");
        String msg = "";
        UserSchedule userSchedule = userScheduleService.selectByPrimaryKey(userScheduleId);
        int rtn = userScheduleService.deleteByPrimaryKey(userScheduleId);
        if(rtn>0){
            Schedule schedule = scheduleService.selectByPrimaryKey(userSchedule.getScheduleid());
            //取到已经选的座
            String clo = schedule.getColum3();
            //移除删除的订单，让别人可选
            String colum3 = StringUtil.removeStr(clo,userSchedule.getSetnum());
            schedule.setColum3(colum3);
            int r = scheduleService.updateByPrimaryKeySelective(schedule);
            if (r>0)
            msg = "删除订单成功";
        }else {
            msg = "删除订单失败";
        }
        model.addAttribute("msg",msg);
        return getSubOrder(session,model);
    }
    @RequestMapping(value = "/orderInfo",method = RequestMethod.GET)
    public String getSubOrder(HttpSession session,Model model){
        logger.info("to get orderInfo");
        User user = (User)session.getAttribute("user");
        List<UserSchedule> userScheduleList = userScheduleService.selectMovieOrderByUser(user);
        model.addAttribute("userScheduleList",userScheduleList);
        return "/movie/orderInfo";
    }
    /**
     * 电影票选择
     * @return
     */
    @RequestMapping(value = "/subOrder",method = RequestMethod.GET)
    public String getSubOrder(String setNum,String scheduleid,Model model,HttpSession session){
        logger.info("to get subOrder");
        Schedule schedule = scheduleService.SubOrder(scheduleid,setNum);
        User user = (User)session.getAttribute("user");
        boolean flag = userScheduleService.saveUserOrder(scheduleid,setNum,user);
        model.addAttribute("msg","选座成功，可到我的订单中查看");
        return getBuyMovieInfo(schedule.getMoveid(),model,session);
    }

    /**
     * 电影票选择
     * @return
     */
    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public String getBuyMovieInfo(String movieid,Model model,HttpSession session){
        logger.info("to get BuyMovieInfo");
        List<Schedule> scheduleList = scheduleService.selectScheduleByMovieId(movieid);
        Movie movie = movieService.selectByPrimaryKey(movieid);
        Map<String,List<Schedule>> scheduleMap = movieService.groupByDate(scheduleList);
        Map<String,Integer> typeNum = movieService.totalSearchMovieType(session,movie.getTypeid());
        model.addAttribute("scheduleMap",scheduleMap);
        model.addAttribute("movie",movie);
        session.setAttribute("typeNum",typeNum);
        return "/movie/buy";
    }
    /**
     * 兴趣推荐
     * @return
     */
    @RequestMapping(value = "/InterestTuijian",method = RequestMethod.GET)
    public String InterestTuijian(Model model, HttpSession session){
        logger.info("to get InterestTuijian");
        List<Type> typeList = typeService.selectAllType();
        List<Movie> movieList = new ArrayList<Movie>();
        List<Movie> xqtj = new ArrayList<Movie>();
        Map<String,Integer> typeNum = (Map<String,Integer>)session.getAttribute("typeNum");
        String maxNumType = StringUtil.findMaxType(typeNum);
        if(!StringUtil.isNotEmpty(maxNumType)){
            maxNumType = typeList.get(0).getTypeid();
        }
        xqtj = movieService.selectMovieByType(maxNumType);
        for(Type type : typeList){
            movieList = movieService.selectMovieByType(type.getTypeid());
            model.addAttribute(type.getColum2(),movieList);
        }
        //今日热播
        String date = StringUtil.getTodayDate();
        List<Schedule> scheduleListJR = scheduleService.selectScheduleByDate(date);
        List<Movie> movieLists = MovieUtil.getTodayMovieBySchedule(scheduleListJR);
        model.addAttribute("movieList",movieLists);
        model.addAttribute("typeList",typeList);
        model.addAttribute("xqtj",xqtj);
        model.addAttribute("scheduleListJR",scheduleListJR);
        return "/movie/index_xqtj";
    }
    /**
     * 电影推荐
     * @return
     */
    @RequestMapping(value = "/movieTuijian",method = RequestMethod.GET)
    public String movieTuijian(Model model, HttpSession session){
        logger.info("to get movieTuijian");
        List<Type> typeList = typeService.selectAllType();
        List<Movie> movieList = new ArrayList<Movie>();
        Map<String,Integer> typeNum = (Map<String,Integer>)session.getAttribute("typeNum");
        String maxNumType = StringUtil.findMaxType(typeNum);
        if(!StringUtil.isNotEmpty(maxNumType)){
            maxNumType = typeList.get(0).getTypeid();
        }
        movieList = movieService.selectMovieByType(maxNumType);
        model.addAttribute("typeList",typeList);
        model.addAttribute("movieList",movieList);
        return "/movie/movieInfo";
    }
    /**
     * 支付
     * @return
     */
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody String ids,Model model, HttpSession session){
        //TODO 具体支付 暂时不实现
        logger.info("to get pay");
        JSONObject object = JSON.parseObject(ids);
        String json = object.getString("ids");
        JSONArray createArray=JSONArray.parseArray(json);
        List<String> list = createArray.toJavaList(String.class);
        boolean flag = userScheduleService.changeOrderState(list);
        String msg = "";
        if(flag){
            msg = "订单支付成功";
        }else {
            msg = "订单支付失败";
        }
        model.addAttribute("msg",msg);
        return getSubOrder(session,model);
    }
    /**
     * 请求查询电影信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/moviePrice",method = RequestMethod.POST)
    public String moviePrice(@RequestBody UserSchedule userSchedul,Model model){
        logger.info("to get moviePrice");
        UserSchedule userSchedule = userScheduleService.selectByPrimaryKey(userSchedul.getId());
        String price = userSchedule.getSchedule().getPrice();
        return price;
    }
    /**
     * 请求查询电影信息
     * @return
     */
    @RequestMapping(value = "/movieInfo",method = RequestMethod.GET)
    public String getMovieInfo(String movieInfoKey,String movieType,Model model){
        logger.info("to get movieInfo");
        List<Type> typeList = typeService.selectAllType();
        List<Movie> movieList = new ArrayList<Movie>();
        if(StringUtil.isNotEmpty(movieInfoKey)){
            movieList = movieService.selectMovieByKey(movieInfoKey);
        }else if(StringUtil.isNotEmpty(movieType)){
            movieList = movieService.selectMovieByType(movieType);
        }
        else {
            movieList = movieService.selectAllMovie();
        }
        model.addAttribute("typeList",typeList);
        model.addAttribute("movieList",movieList);
        return "/movie/movieInfo";
    }
    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        List<Type> typeList = typeService.selectAllType();
        model.addAttribute("typeList",typeList);
        return "/movie/add";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Movie movie, MultipartFile file, Model model, HttpSession session) throws IOException {
        logger.info("to get add");
        String msg = "";
        //文件上传
        Pic pic = fileService.fileUpload(file);
        //保存文件到数据库
        pic = picService.insertSelective(pic);
        //电影图片信息设置
        movie.setPicid(pic.getPicid());
        //电影信息存到数据库
        int rtn = movieService.insertSelective(movie);
        if(rtn>0){
            msg = "添加功能成功！";
        }else   {
            msg = "添加功能失败！";
        }
        model.addAttribute("msg",msg);
        return "/index";
    }

    @RequestMapping(value="/search",method=RequestMethod.GET)
    public String list(@RequestParam(name="current",defaultValue="1") int current,
                       @RequestParam(name="key",defaultValue="")String key,
                       @RequestParam(name="offset",defaultValue="5")int offset,
                       Model model){
        PageInfo<Movie> moviePageInfo = movieService.selectMovieByKey(current,key,offset);
        model.addAttribute("moviePage", moviePageInfo);
        return "/movie/select";
    }
    /**
     * 获取图片并输出到界面
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getPic",method = RequestMethod.GET)
    public void getVerify(String path,HttpSession session, HttpServletResponse response) throws Exception {
        logger.info("to getPic");
        //获取验证码接口
        validateCodeService.outPutToClient(path,response);
    }
    /**
     * 获取图片并输出到界面
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getPicById",method = RequestMethod.GET)
    public void getPicById(String picId,HttpSession session, HttpServletResponse response) throws Exception {
        logger.info("to getPicById");
        Pic pic = picService.selectByPrimaryKey(picId);
        String path = pic.getPicurl();
        //获取验证码接口
        validateCodeService.outPutToClient(path,response);
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String moveid, Model model){
        logger.info("to get delete");
        int rtn = movieService.deleteByPrimaryKey(moveid);
        if(rtn == 1){
            model.addAttribute("msg","删除成功");
        }else{
            model.addAttribute("msg","删除失败");
        }
        return list(1,"",5,model);
    }

    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEdit(String movieid, Model model){
        logger.info("to get edit");
        Movie movie = movieService.selectByPrimaryKey(movieid);
        List<Type> typeList = typeService.selectAllType();
        model.addAttribute("typeList",typeList);
        model.addAttribute("movieEdit",movie);
        return "/movie/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody Movie movie, Model model){
        logger.info("to post edit,Movie :");
        String msg = "";
        int rtn = movieService.updateByPrimaryKeySelective(movie);
        if(rtn == 1){
            msg = "修改成功！";
        }else{
            msg = "修改失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
