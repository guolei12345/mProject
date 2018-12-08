package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Follow;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);
}