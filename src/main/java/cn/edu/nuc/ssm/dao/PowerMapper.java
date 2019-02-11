package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerMapper {
    int deleteByPrimaryKey(String powerid);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(String powerid);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    List<Power> selectAllParPower(@Param(value = "status")String status, @Param(value = "type")String type);

    int selectPowerCount(@Param(value = "status")String status);

    List<Power> selectPowerByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);
}