package cn.edu.nuc.ssm.controller;

import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.logger.BaseLog;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private UserService userService;
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
        logger.info("to post login");
        return "/index.html";
    }
}
