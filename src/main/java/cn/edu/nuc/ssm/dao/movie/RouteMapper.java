package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Route;

public interface RouteMapper {
    int deleteByPrimaryKey(String routid);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(String routid);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}