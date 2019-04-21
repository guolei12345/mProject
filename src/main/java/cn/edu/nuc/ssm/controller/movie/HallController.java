package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Pic;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.service.interfaces.movie.HallService;
import cn.edu.nuc.ssm.service.interfaces.movie.PicService;
import cn.edu.nuc.ssm.service.interfaces.movie.TypeService;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hall")
public class HallController extends BaseController {
    @Autowired
    private HallService hallService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FileService fileService;
    @Autowired
    private PicService picService;
    @Autowired
    private ValidateCodeService validateCodeService;
    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        return "/hall/add";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Hall hall, MultipartFile file, Model model, HttpSession session) throws IOException {
        logger.info("to get add");
        String msg = "";
        int rtn = hallService.insertSelective(hall);
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
        PageInfo<Hall> hallPageInfo = hallService.selectHallByKey(current,key,offset);
        model.addAttribute("hallPage", hallPageInfo);
        return "/hall/select";
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String hallid, Model model){
        logger.info("to get delete");
        int rtn = hallService.deleteByPrimaryKey(hallid);
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
    public String getEdit(String hallid, Model model){
        logger.info("to get edit");
        Hall hall = hallService.selectByPrimaryKey(hallid);
        model.addAttribute("hallEdit",hall);
        return "/hall/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody Hall hall, Model model){
        logger.info("to post edit,Hall :");
        String msg = "";
        int rtn = hallService.updateByPrimaryKeySelective(hall);
        if(rtn == 1){
            msg = "修改成功！";
        }else{
            msg = "修改失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
