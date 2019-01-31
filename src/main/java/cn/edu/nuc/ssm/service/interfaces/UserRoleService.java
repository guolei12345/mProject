package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.entity.UserRole;

public interface UserRoleService {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    UserRole selectByUserId(String userid);

    int saveOrUpdateUserRole(User user);
}