package cn.edu.nuc.ssm.service;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.ssm.BaseTest;
import cn.edu.nuc.ssm.entity.Account;
import cn.edu.nuc.ssm.service.interfaces.AccountService;

public class AccountServiceTest extends BaseTest {
	
	@Autowired
	private AccountService accountService;

	@Test
	public void testLogin() {
		
		Account account = accountService.login("zhangsan@163.com", "123456");
		
		System.out.println( account );
		Assert.assertNotNull(account);
	}

}
