package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.RolePower;

public interface RolePowerMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    RolePower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);
}