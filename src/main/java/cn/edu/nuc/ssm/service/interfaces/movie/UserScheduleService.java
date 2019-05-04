package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.movie.UserSchedule;
import cn.edu.nuc.ssm.entity.power.User;

import java.util.List;

public interface UserScheduleService {
    int deleteByPrimaryKey(String id);

    int insert(UserSchedule record);

    int insertSelective(UserSchedule record);

    UserSchedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserSchedule record);

    int updateByPrimaryKey(UserSchedule record);

    boolean saveUserOrder(String scheduleid, String setNum, User user);

    List<UserSchedule> selectMovieOrderByUser(User user);

    int delectOrder(String userScheduleId);

    boolean changeOrderState(List<String> list);
}
