package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String scheduleid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String scheduleid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}