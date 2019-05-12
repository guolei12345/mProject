package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.entity.movie.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String scheduleid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String scheduleid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    int selectScheduleCount();

    List<Schedule> selectScheduleByKey(@Param(value = "start")int start, @Param(value = "offset")int offset);

    List<Schedule> selectScheduleByMovieId(@Param(value = "movieid")String movieid);

    List<Schedule> selectScheduleByDate(@Param(value = "date")String date);
}