package cn.edu.nuc.ssm.service.interfaces.power;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.power.Role;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    PageInfo<Role> selectRoleByKey(int current, String key, int offset);
}