package cn.edu.nuc.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.ssm.service.interfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	public Account login(String account, String password) {
		
		Account ac = accountMapper.findByAccount(account);
		
		if( ac == null ){
			throw new RuntimeException("用户名或密码不正确");
		} else if( ! password.equals( ac.getPassword() ) ){
			throw new RuntimeException("用户名或密码不正确");
		}
		
		return ac;
	}

}
