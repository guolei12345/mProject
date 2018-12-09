package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Power;

public interface PowerMapper {
    int deleteByPrimaryKey(String powerid);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(String powerid);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}