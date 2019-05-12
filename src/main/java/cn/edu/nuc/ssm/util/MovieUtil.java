package cn.edu.nuc.ssm.util;

import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Schedule;

import java.util.ArrayList;
import java.util.List;

public class MovieUtil {
    /**
     * 根据排片赛选电影 不重复
     * @param scheduleListJR
     * @return
     */
    public static List<Movie> getTodayMovieBySchedule(List<Schedule> scheduleListJR) {
        List<Movie> list = new ArrayList<>();
        if(scheduleListJR!=null&&scheduleListJR.size()>0){
            for (Schedule schedule:scheduleListJR){
                boolean flag = list.contains(schedule.getMovie());
                if(flag){
                    continue;
                }else {
                    list.add(schedule.getMovie());
                }
            }
        }
        return list;
    }
}
