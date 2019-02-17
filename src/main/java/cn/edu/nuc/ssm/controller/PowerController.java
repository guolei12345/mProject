package cn.edu.nuc.ssm.controller;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.entity.Role;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.service.interfaces.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/power")
public class PowerController extends BaseController {
    @Autowired
    PowerService powerService;
    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        List<Power> powerList = powerService.selectAllParPower("1","1");
        model.addAttribute("powerList",powerList);
        return "/power/add";
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Power power ,Model model){
        logger.info("to get add");
        String msg = "";
        int rtn = powerService.insertSelective(power);
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
        PageInfo<Power> powerPageInfo = powerService.selectPowerByKey(current,key,offset);
        model.addAttribute("powerPage", powerPageInfo);
        return "/power/select";
    }

    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEdit(String powerid, Model model){
        logger.info("to get edit");
        List<Power> powerList = powerService.selectAllParPower("1","1");
        model.addAttribute("powerList",powerList);
        Power power = powerService.selectByPrimaryKey(powerid);
        model.addAttribute("powerEdit",power);
        return "/power/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody Power power, Model model){
        logger.info("to post edit,userInfo :");
        String msg = "";
        int rtn = powerService.updateByPrimaryKeySelective(power);
        if(rtn == 1){
            msg = "修改功能信息成功！";
        }else{
            msg = "修改功能信息失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String powerid, Model model){
        logger.info("to get delete");
        String msg = "";
        int rtn = powerService.deleteByPrimaryKey(powerid);
        if(rtn > 0){
            msg = "删除成功！";
        }else{
            msg = "删除失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
