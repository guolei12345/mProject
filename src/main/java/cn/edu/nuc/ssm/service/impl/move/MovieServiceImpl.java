package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.MovieMapper;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Schedule;
import cn.edu.nuc.ssm.service.interfaces.movie.MovieService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public int deleteByPrimaryKey(String moveid) {
        return movieMapper.deleteByPrimaryKey(moveid);
    }

    @Override
    public int insert(Movie record) {
        return movieMapper.insert(record);
    }

    @Override
    public int insertSelective(Movie record) {
        if(!StringUtil.isNotEmpty(record.getMoveid())){
            record.setMoveid(StringUtil.getUUId());
        }
        return movieMapper.insertSelective(record);
    }

    @Override
    public Movie selectByPrimaryKey(String moveid) {
        return movieMapper.selectByPrimaryKey(moveid);
    }

    @Override
    public int updateByPrimaryKeySelective(Movie record) {
        return movieMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Movie record) {
        return movieMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Movie> selectMovieByKey(int current, String key, int offset) {
        PageInfo pageInfo = new PageInfo(current);
        pageInfo.setOffset(offset);
        String keyMsg = "%"+key+"%";
        int count = movieMapper.selectMovieCount(keyMsg);
        pageInfo.setCount(count);
        List<Movie> list = movieMapper.selectMovieByKey(keyMsg,pageInfo.getStart(),pageInfo.getOffset());
        pageInfo.setList(list);
        return  pageInfo;
    }

    @Override
    public List<Movie> selectAllMovie() {
        return movieMapper.selectAllMovie();
    }

    @Override
    public Map<String,List<Schedule>> groupByDate(List<Schedule> scheduleList) {
        Map<String,List<Schedule>> map = new HashMap<>();
        for(Schedule schedule:scheduleList){
            String date = schedule.getTime();
            boolean flag = map.containsKey(date);
            List<Schedule> schedules = new ArrayList<Schedule>();
            if(flag){
                schedules = map.get(date);
                schedules.add(schedule);
                map.remove(date);

            }else{
                schedules.add(schedule);
                map.put(date,schedules);
            }
            map.put(date,schedules);
        }
        return map;
    }
}
