package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Schedule;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface MovieService {
    int deleteByPrimaryKey(String moveid);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(String moveid);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    PageInfo<Movie> selectMovieByKey(int current, String key, int offset);

    List<Movie> selectAllMovie();

    Map<String,List<Schedule>> groupByDate(List<Schedule> scheduleList);

    List<Movie> selectMovieByKey(String movieInfoKey);

    List<Movie> selectMovieByType(String movieType);

    Map<String, Integer> totalSearchMovieType(HttpSession session, String typeid);
}