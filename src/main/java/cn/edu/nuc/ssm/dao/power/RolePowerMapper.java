package cn.edu.nuc.ssm.dao.power;

import cn.edu.nuc.ssm.entity.power.RolePower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePowerMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    RolePower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);

    List<RolePower> selectByRoleId(@Param(value = "roleid") String roleid);

    void deleteByRoleId(@Param(value = "roleid")String roleid);
}