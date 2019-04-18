package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Movie;

public interface MovieService {
    int deleteByPrimaryKey(String moveid);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(String moveid);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    PageInfo<Movie> selectMovieByKey(int current, String key, int offset);
}