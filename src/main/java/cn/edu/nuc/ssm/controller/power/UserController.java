package cn.edu.nuc.ssm.controller.power;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.power.Role;
import cn.edu.nuc.ssm.entity.power.User;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.enums.UpdatePassCodeEnum;
import cn.edu.nuc.ssm.service.interfaces.power.PowerService;
import cn.edu.nuc.ssm.service.interfaces.power.RoleService;
import cn.edu.nuc.ssm.service.interfaces.power.UserRoleService;
import cn.edu.nuc.ssm.service.interfaces.power.UserService;
import cn.edu.nuc.ssm.util.PropertyUtil;
import cn.edu.nuc.ssm.util.RedisUtil;
import cn.edu.nuc.ssm.util.StringUtil;
import cn.edu.nuc.ssm.util.VerifyUtil;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private ValidateCodeService validateCodeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PowerService powerService;
    /**
     * 请求登陆页面
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndex(){
        logger.info("to get index");
        return "/index";
    }
    /**
     * 请求登陆页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(){
        logger.info("to get login");
        return "/user/login";
    }
    /**
     * 登陆
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postLogin(User user, Model model, HttpSession session){
        logger.info("Controller 开始调用登陆 Service start info{}",user.toString());
        String msg = "";
        int rtn = 0;
        String code = "";
        boolean useRedis = PropertyUtil.getPropertyBool("useRedis");
        if(useRedis){
            code = RedisUtil.getJedis().get("code").toUpperCase();
        }else{
            code = session.getAttribute("code").toString().toUpperCase();
        }
        //没有输入信息返回
        if(user == null) return "/user/login";
        rtn = userService.login(user,code);
        msg = LoginCodeEnum.getLoginValue(rtn);
        logger.info("Controller 调用登陆 Service end info：{}",msg);
        model.addAttribute("msg",msg);
        logger.info(msg);
        if(rtn == LoginCodeEnum.getLoginCode(LoginCodeEnum.登陆成功.toString())){
            resetUser(user,session,model);
            return "/index";
        }else{
            return "/user/login";
        }
    }

    /**
     * 重置 user信息
     * @param userInfo
     * @param session
     */
    private void resetUser(User userInfo, HttpSession session, Model model) {
        User user = userService.selectByUser(userInfo);
        if(StringUtil.isNotEmpty(user.getRoleid())){
            Role role = roleService.selectByPrimaryKey(user.getRoleid());
            if(role != null)
            user.setRole(role);
        }
        session.removeAttribute("user");
        session.setAttribute("user",user);
        model.addAttribute("user",user);
    }

    /**
     * 请求注册页面
     * @return
     */
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String getRegist(){
        logger.info("to get regist");
        return "/user/regist";
    }
    /**
     * 注册
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String postRegist(User user, Model model, HttpSession session){
        logger.info("Controller 开始调用注册 Service start info{}",user.toString());
        String msg = "";
        int rtn = 0;
        String code = "";
        boolean useRedis = PropertyUtil.getPropertyBool("useRedis");
        if(useRedis){
            code = RedisUtil.getJedis().get("code").toUpperCase();
        }else{
            code = session.getAttribute("code").toString().toUpperCase();
        }
        //没有输入信息返回
        if(user == null) return "/user/regist";
        rtn = userService.regist(user,code);
        msg = RegistCodeEnum.getRegistValue(rtn);
        logger.info("Controller 调用注册 Service end info：{}",msg);
        model.addAttribute("msg",msg);
        if(rtn==RegistCodeEnum.getRegistCode(RegistCodeEnum.注册成功.toString())){
            User userReg = userService.selectByUser(user);
            userReg.setRoleid("333");
            int r = userRoleService.saveOrUpdateUserRole(userReg);
            return "/user/login";
        }else{
            return "/user/regist";
        }
    }

    /**
     * 请求修改密码页面
     * @return
     */
    @RequestMapping(value = "/updatePass",method = RequestMethod.GET)
    public String getUpdatePass() {
        logger.info("to get updatePass");
        return "/user/updatePass";
    }
    /**
     * 请求修改密码页面
     * @return
     */
    @RequestMapping(value = "/updatePass",method = RequestMethod.POST)
    public String postUpdatePassByEmail(User user,HttpSession session) throws Exception {
        logger.info("to post updatePass");
        //发送验证码
        int rtn = userService.updatePassWord(user, false);
        if(rtn == UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.修改密码成功.toString())){
            return "/user/login";
        }else{
            return "/user/updatePass";
        }
    }

    /**
     * 请求修改密码页面
     * 登陆以后修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String getUpdate() {
        logger.info("to get update");
        return "/user/update";
    }
    /**
     * 请求修改密码页面
     * 登陆以后修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String postUpdatePassByOld(User user,Model model) throws Exception {
        logger.info("to post updatePass");
        //发送验证码
        int rtn = userService.updatePassWord(user, true);
        model.addAttribute("msg",UpdatePassCodeEnum.getUpdateValue(rtn));
        return "/index";
    }
    /**
     * 获取图片验证码并输出到界面
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getVerify",method = RequestMethod.GET)
    public void getVerify(HttpSession session, HttpServletResponse response) throws Exception {
        logger.info("to getVerify");
        //登陆页面验证码缓存到session
        String code = VerifyUtil.getVerifyCode1();
        boolean useRedis = PropertyUtil.getPropertyBool("useRedis");
        if(useRedis){
            //设置缓存
            RedisUtil.getJedis().set("code", code);
        }else {
            //存到session中
            session.setAttribute("code",code);
        }
        logger.info("code:{}",code);
        //获取验证码接口
        byte[] bytes = validateCodeService.enGetVerify(code);
        validateCodeService.outPutToClient(bytes,response);
    }

    /**
     * 发送验证码
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/sendCheck",method = RequestMethod.GET)
    public void getSendCheck(HttpSession session, HttpServletResponse response,String num) throws Exception {
        logger.info("to sendCheck：num："+num);
        userService.sendCheck(num);
    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String getUserInfo(HttpSession session){
        logger.info("to get userInfo");
        return "/user/userInfo";
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String getSelect(String key, Model model){
        logger.info("to get select");
        List<User> userList = userService.selectAllUser();
        model.addAttribute("userList",userList);
        return "/user/select";
    }
    @RequestMapping(value="search",method=RequestMethod.GET)
    public String list(@RequestParam(name="current",defaultValue="1") int current,
                       @RequestParam(name="key",defaultValue="")String key,
                       @RequestParam(name="offset",defaultValue="5")int offset,
                       Model model){
        PageInfo pageInfo = userService.selectAllUserByKey(key,current,offset);
        model.addAttribute("pageInfo",pageInfo);
        return "/user/select";
    }
    /**
     * 完善用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String postUpdateUser(User user,Model model,HttpSession session){
        logger.info("Controller 开始调用完善用户信息 Service start info{}",user.toString());
        String msg = "";
        int rtn = userService.updateByPrimaryKeySelective(user);
        if(rtn == 1){
            resetUser(user,session,model);
            msg = "完善信息成功";
        }else {
            msg = "完善信息失败";
        }
        model.addAttribute("msg",msg);
        return "/index";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEdit(String userid, Model model){
        logger.info("to get edit");
        User user = userService.selectByPrimaryKey(userid);
        List<Role> roleList = roleService.selectAllRole();
        model.addAttribute("userEdit",user);
        model.addAttribute("roleList",roleList);
        return "/user/edit";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String postEdit(@RequestBody User user, Model model){
        logger.info("to post edit,userInfo :");
        String msg = "";
        int rtn = userRoleService.saveOrUpdateUserRole(user);
        if(rtn == 1){
            msg = "修改用户权限成功！";
        }else{
            msg = "修改用户权限失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String userid, Model model){
        logger.info("to get delete");
        int rtn = userService.deleteUser(userid);
        if(rtn == 1){
            model.addAttribute("msg","删除成功");
        }else{
            model.addAttribute("msg","删除失败");
        }
        return list(1,"",5,model);
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        List<Role> roleList = roleService.selectAllRole();
        model.addAttribute("roleList",roleList);
        return "/user/add";
    }

    /**
     * 请求查询用户
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(User user,Model model){
        logger.info("to post add");
        String msg = "";
        int rtn = userService.saveUser(user);
        if(rtn>0){
            msg = "增加用户信息成功！";
        }
        return "/index";
    }
}
