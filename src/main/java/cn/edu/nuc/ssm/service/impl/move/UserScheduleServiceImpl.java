package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.ScheduleMapper;
import cn.edu.nuc.ssm.dao.movie.UserScheduleMapper;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.entity.movie.UserSchedule;
import cn.edu.nuc.ssm.entity.power.User;
import cn.edu.nuc.ssm.service.interfaces.movie.ScheduleService;
import cn.edu.nuc.ssm.service.interfaces.movie.UserScheduleService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScheduleServiceImpl implements UserScheduleService {
    @Autowired
    private UserScheduleMapper userScheduleMapper;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return userScheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserSchedule record) {
        return userScheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserSchedule record) {
        return userScheduleMapper.insertSelective(record);
    }

    @Override
    public UserSchedule selectByPrimaryKey(String id) {
        return userScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserSchedule record) {
        return userScheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserSchedule record) {
        return userScheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean saveUserOrder(String scheduleid, String setNum, User user) {
        boolean flag = false;
        UserSchedule userSchedule = new UserSchedule();
        userSchedule.setId(StringUtil.getUUId());
        userSchedule.setSetnum(setNum);
        if(user != null && StringUtil.isNotEmpty(user.getUserid())){
            userSchedule.setUserid(user.getUserid());
        }
        userSchedule.setScheduleid(scheduleid);
        int rtn = insertSelective(userSchedule);
        if(rtn>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<UserSchedule> selectMovieOrderByUser(User user) {
        List<UserSchedule> userScheduleList = null;
        if(user != null && StringUtil.isNotEmpty(user.getUserid())){
            userScheduleList = userScheduleMapper.selectMovieOrderByUser(user.getUserid());
        }
        return userScheduleList;
    }

    @Override
    public int delectOrder(String userScheduleId) {
        return 0;
    }

    @Override
    public boolean changeOrderState(List<String> list) {
        boolean flag = true;
        if(list != null){
            for (String id:list){
                UserSchedule userSchedule = userScheduleMapper.selectByPrimaryKey(id);
                userSchedule.setColum1("1");
                userScheduleMapper.updateByPrimaryKey(userSchedule);
            }
        }else{
            flag = false;
        }
        return flag;
    }
}
