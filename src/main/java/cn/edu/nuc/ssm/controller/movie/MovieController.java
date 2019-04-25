package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Pic;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.entity.power.User;
import cn.edu.nuc.ssm.service.interfaces.movie.MovieService;
import cn.edu.nuc.ssm.service.interfaces.movie.PicService;
import cn.edu.nuc.ssm.service.interfaces.movie.ScheduleService;
import cn.edu.nuc.ssm.service.interfaces.movie.TypeService;
import cn.edu.nuc.ssm.service.interfaces.util.FileService;
import cn.edu.nuc.ssm.util.PropertyUtil;
import cn.edu.nuc.ssm.util.RedisUtil;
import cn.edu.nuc.ssm.util.VerifyUtil;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    /**
     * 电影票选择
     * @return
     */
    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public String getBuyMovieInfo(String movieid,Model model){
        logger.info("to get BuyMovieInfo");
        List<Schedule> scheduleList = scheduleService.selectScheduleByMovieId(movieid);
        Movie movie = movieService.selectByPrimaryKey(movieid);
        Map<String,List<Schedule>> scheduleMap = movieService.groupByDate(scheduleList);
        model.addAttribute("scheduleMap",scheduleMap);
        model.addAttribute("movie",movie);
        return "/movie/buy";
    }
    /**
     * 请求查询电影信息
     * @return
     */
    @RequestMapping(value = "/movieInfo",method = RequestMethod.GET)
    public String getMovieInfo(Model model){
        logger.info("to get movieInfo");
        List<Movie> movieList = movieService.selectAllMovie();
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
