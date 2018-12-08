package cn.edu.nuc.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.ssm.entity.Account;
import cn.edu.nuc.ssm.service.interfaces.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login2(){
		//todo
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Account account, HttpSession session){
		
		try {
			Account ac = accountService.login(account.getEmail(), account.getPassword());
			session.setAttribute("account", ac);
			
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:login";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		
		return "index";
	}

}
