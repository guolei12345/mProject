package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.entity.movie.UserSchedule;
import cn.edu.nuc.ssm.entity.power.User;

import java.util.List;

public interface ScheduleService {
    int deleteByPrimaryKey(String scheduleid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String scheduleid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    PageInfo<Schedule> selectScheduleByKey(int current, String key, int offset);
    //电影排片信息查询
    List<Schedule> selectScheduleByMovieId(String movieid);

    Schedule SubOrder(String scheduleid, String setNum);
}