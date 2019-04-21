package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(String typeid);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String typeid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> selectAllType();

    int selectTypeCount(@Param(value = "key")String key);

    List<Type> selectTypeByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);

}