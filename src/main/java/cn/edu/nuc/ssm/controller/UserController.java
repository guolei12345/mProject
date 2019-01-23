package cn.edu.nuc.ssm.controller;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.NumTypeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.enums.UpdatePassCodeEnum;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.MailUtil;
import cn.edu.nuc.ssm.util.VerifyUtil;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private ValidateCodeService validateCodeService;
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
        String code = session.getAttribute("code").toString().toUpperCase();
        //没有输入信息返回
        if(user == null) return "/user/login";
        rtn = userService.login(user,code,session);
        msg = LoginCodeEnum.getLoginValue(rtn);
        logger.info("Controller 调用登陆 Service end info：{}",msg);
        model.addAttribute("msg",msg);
        logger.info(msg);
        if(rtn == LoginCodeEnum.getLoginCode(LoginCodeEnum.登陆成功.toString())){
            return "/index";
        }else{
            return "/user/login";
        }
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
        String code = session.getAttribute("code").toString().toUpperCase();
        //没有输入信息返回
        if(user == null) return "/user/regist";
        rtn = userService.regist(user,code);
        msg = RegistCodeEnum.getRegistValue(rtn);
        logger.info("Controller 调用注册 Service end info：{}",msg);
        model.addAttribute("msg",msg);
        if(rtn==RegistCodeEnum.getRegistCode(RegistCodeEnum.注册成功.toString())){
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
    public String postUpdatePassByEmail(User user) throws Exception {
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
        session.removeAttribute("code");
        session.setAttribute("code",code);
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
}
