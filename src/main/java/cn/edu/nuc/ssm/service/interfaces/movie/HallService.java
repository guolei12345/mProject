package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;

public interface HallService {
    int deleteByPrimaryKey(String hallid);

    int insert(Hall record);

    int insertSelective(Hall record);

    Hall selectByPrimaryKey(String hallid);

    int updateByPrimaryKeySelective(Hall record);

    int updateByPrimaryKey(Hall record);

    PageInfo<Hall> selectHallByKey(int current, String key, int offset);
}