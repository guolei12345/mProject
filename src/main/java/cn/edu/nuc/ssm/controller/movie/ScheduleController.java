package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.service.interfaces.movie.*;
import cn.edu.nuc.ssm.service.interfaces.util.FileService;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FileService fileService;
    @Autowired
    private PicService picService;
    @Autowired
    private ValidateCodeService validateCodeService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private HallService hallService;
    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        List<Movie> movieList = movieService.selectAllMovie();
        List<Hall> hallList = hallService.selectAllHall();
        model.addAttribute("movieList",movieList);
        model.addAttribute("hallList",hallList);
        return "/schedule/add";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Schedule schedule, MultipartFile file, Model model, HttpSession session) throws IOException {
        logger.info("to get add");
        String msg = "";
        int rtn = scheduleService.insertSelective(schedule);
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
        PageInfo<Schedule> schedulePageInfo = scheduleService.selectScheduleByKey(current,key,offset);
        model.addAttribute("schedulePage", schedulePageInfo);
        return "/schedule/select";
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String scheduleid, Model model){
        logger.info("to get delete");
        int rtn = scheduleService.deleteByPrimaryKey(scheduleid);
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
    public String getEdit(String scheduleid, Model model){
        logger.info("to get edit");
        Schedule schedule = scheduleService.selectByPrimaryKey(scheduleid);
        model.addAttribute("scheduleEdit",schedule);
        return "/schedule/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody Schedule schedule, Model model){
        logger.info("to post edit,Schedule :");
        String msg = "";
        int rtn = scheduleService.updateByPrimaryKeySelective(schedule);
        if(rtn == 1){
            msg = "修改成功！";
        }else{
            msg = "修改失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
