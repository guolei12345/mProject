package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(String moveid);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(String moveid);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    int selectMovieCount(@Param(value = "key")String key);

    List<Movie> selectMovieByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);

    List<Movie> selectAllMovie();
}