package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.Weibo;

public interface WeiboMapper {
    int deleteByPrimaryKey(Integer wid);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);
}