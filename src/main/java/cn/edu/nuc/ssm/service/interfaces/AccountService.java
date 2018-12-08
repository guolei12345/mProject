package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.Account;

public interface AccountService {
	
	/**
	 * 用户登录
	 * @param account 帐号
	 * @param password 密码
	 * @return Account
	 */
	Account login(String account, String password);

}
