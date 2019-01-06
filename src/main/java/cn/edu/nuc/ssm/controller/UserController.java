package cn.edu.nuc.ssm.controller;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.VerifyUtil;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    /**
     * 登陆
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postLogin(User user, Model model, HttpSession session){
        logger.info("to post login");
        String msg = "";
        //校验是否为手机号
        if(user == null) return "/user/login";
        String tell = user.getTell();
        boolean loginFlag = false;
        boolean tellFlag = CheckUtil.isMobilephone(tell);
        if(tellFlag){
            msg = "tell ok,check login";
            logger.info(msg);
            loginFlag = userService.login(user);
            msg = "user login :"+loginFlag;
        }else {
            msg = "error tell number";
        }
        logger.info(msg);
        if(loginFlag){
            session.setAttribute("user",user);
            return "/index.jsp";
        }else{
            return "/user/login";
        }
    }
}
