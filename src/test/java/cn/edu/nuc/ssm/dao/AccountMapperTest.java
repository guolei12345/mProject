package cn.edu.nuc.ssm.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.ssm.BaseTest;
import cn.edu.nuc.ssm.entity.Account;

public class AccountMapperTest extends BaseTest {

	@Autowired
	private AccountMapper accountMapper;
	
	@Test
	public void testSelectByPrimaryKey(){
		
		Account account = accountMapper.selectByPrimaryKey(1);
		
		System.out.println( account );
		
		Assert.assertNotNull( account );
	}
}
