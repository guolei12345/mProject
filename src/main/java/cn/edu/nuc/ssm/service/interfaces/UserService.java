package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.User;

public interface UserService {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}