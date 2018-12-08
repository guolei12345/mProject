package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Liked;
import cn.edu.nuc.ssm.entity.LikedKey;

public interface LikedMapper {
    int deleteByPrimaryKey(LikedKey key);

    int insert(Liked record);

    int insertSelective(Liked record);

    Liked selectByPrimaryKey(LikedKey key);

    int updateByPrimaryKeySelective(Liked record);

    int updateByPrimaryKey(Liked record);
}