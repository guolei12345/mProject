package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();
}