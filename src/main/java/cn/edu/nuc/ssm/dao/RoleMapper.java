package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    int selectRoleCount(@Param(value = "key")String key);

    List<Role> selectRoleByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);
}