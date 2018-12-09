package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.Power;

/**
 * 权限表查询接口
 */
public interface PowerService {
    int deleteByPrimaryKey(String powerid);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(String powerid);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}