package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.HallMapper;
import cn.edu.nuc.ssm.dao.movie.ScheduleMapper;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.service.interfaces.movie.HallService;
import cn.edu.nuc.ssm.service.interfaces.movie.ScheduleService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public int deleteByPrimaryKey(String moveid) {
        return scheduleMapper.deleteByPrimaryKey(moveid);
    }

    @Override
    public int insert(Schedule record) {
        return scheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Schedule record) {
        if(!StringUtil.isNotEmpty(record.getScheduleid())){
            record.setScheduleid(StringUtil.getUUId());
        }
        return scheduleMapper.insertSelective(record);
    }

    @Override
    public Schedule selectByPrimaryKey(String moveid) {
        return scheduleMapper.selectByPrimaryKey(moveid);
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return scheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Schedule> selectScheduleByKey(int current, String key, int offset) {
        PageInfo pageInfo = new PageInfo(current);
        pageInfo.setOffset(offset);
        String keyMsg = "%"+key+"%";
        int count = scheduleMapper.selectScheduleCount();
        pageInfo.setCount(count);
        List<Schedule> list = scheduleMapper.selectScheduleByKey(pageInfo.getStart(),pageInfo.getOffset());
        pageInfo.setList(list);
        return  pageInfo;
    }

    @Override
    public List<Schedule> selectScheduleByMovieId(String movieid) {
        List<Schedule> list = scheduleMapper.selectScheduleByMovieId(movieid);
        return list;
    }
}
