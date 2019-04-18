package cn.edu.nuc.ssm.controller.power;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.power.Power;
import cn.edu.nuc.ssm.entity.power.Role;
import cn.edu.nuc.ssm.service.interfaces.power.PowerService;
import cn.edu.nuc.ssm.service.interfaces.power.RolePowerService;
import cn.edu.nuc.ssm.service.interfaces.power.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;
    @Autowired
    PowerService powerService;
    @Autowired
    RolePowerService rolePowerService;
    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        return "/role/add";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Role role ,Model model){
        logger.info("to get add");
        String msg = "";
        int rtn = roleService.insertSelective(role);
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
        PageInfo<Role> rolePageInfo = roleService.selectRoleByKey(current,key,offset);
        model.addAttribute("rolePage", rolePageInfo);
        return "/role/select";
    }

    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEdit(String roleid, Model model){
        logger.info("to get edit");
        Role role = roleService.selectByPrimaryKey(roleid);
        model.addAttribute("roleEdit",role);
        return "/role/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody Role role, Model model){
        logger.info("to post edit,userInfo :");
        String msg = "";
        int rtn = roleService.updateByPrimaryKeySelective(role);
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
    public String getDelete(String roleid, Model model){
        logger.info("to get delete");
        String msg = "";
        int rtn = roleService.deleteByPrimaryKey(roleid);
        if(rtn > 0){
            msg = "删除成功！";
        }else{
            msg = "删除失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/option",method = RequestMethod.GET)
    public String getOption(String roleid,Model model){
        logger.info("to get option");
        Role role = roleService.selectByPrimaryKey(roleid);
        //全部功能列表
        List<Power> powerList = powerService.selectAllPower();
        //没有的权限列表
        List<Power> noPowerList = new ArrayList<Power>();
        if(role.getPowerList() != null) {
            powerList.removeAll(role.getPowerList());
        }
        noPowerList = powerList;
        model.addAttribute("noPowerList",noPowerList);
        model.addAttribute("role",role);
        return "/role/option";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/savePower",method = RequestMethod.GET)
    public String postOption(String roleid,String powerList ,Model model){
        logger.info("to get savePower");
        String msg = "";
        int rtn = rolePowerService.saveOrUpdateRolePower(roleid,powerList);
        if(rtn>0){
            msg = "添加功能成功！";
        }else   {
            msg = "添加功能失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
