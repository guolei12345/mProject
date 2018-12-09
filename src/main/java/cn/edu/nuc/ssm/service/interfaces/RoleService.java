package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.Role;

public interface RoleService {
    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}