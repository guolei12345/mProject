package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Hall;

public interface HallMapper {
    int deleteByPrimaryKey(String hallid);

    int insert(Hall record);

    int insertSelective(Hall record);

    Hall selectByPrimaryKey(String hallid);

    int updateByPrimaryKeySelective(Hall record);

    int updateByPrimaryKey(Hall record);
}