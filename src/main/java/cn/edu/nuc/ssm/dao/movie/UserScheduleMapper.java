package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.UserSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserScheduleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserSchedule record);

    int insertSelective(UserSchedule record);

    UserSchedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserSchedule record);

    int updateByPrimaryKey(UserSchedule record);

    List<UserSchedule> selectMovieOrderByUser(@Param(value = "userid") String userid);
}