package cn.edu.nuc.ssm.controller;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.VerifyUtil;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.rmi.runtime.Log;
import sun.security.provider.VerificationProvider;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

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
            session.setAttribute("user",user);
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
     * 获取验证码的
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
}
