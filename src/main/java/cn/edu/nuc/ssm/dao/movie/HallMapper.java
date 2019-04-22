package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Hall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallMapper {
    int deleteByPrimaryKey(String hallid);

    int insert(Hall record);

    int insertSelective(Hall record);

    Hall selectByPrimaryKey(String hallid);

    int updateByPrimaryKeySelective(Hall record);

    int updateByPrimaryKey(Hall record);

    int selectHallCount(@Param(value = "key")String key);

    List<Hall> selectHallByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);

    List<Hall> selectAllHall();
}