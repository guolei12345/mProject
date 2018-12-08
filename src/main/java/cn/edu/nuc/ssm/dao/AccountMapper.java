package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer aid);
    
    Account findByAccount(String account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}