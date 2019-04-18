package cn.edu.nuc.ssm.service.interfaces.power;

import cn.edu.nuc.ssm.entity.power.RolePower;

public interface RolePowerService {
    int deleteByPrimaryKey(String id);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    RolePower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);

    int saveOrUpdateRolePower(String roleid, String powerList);
}