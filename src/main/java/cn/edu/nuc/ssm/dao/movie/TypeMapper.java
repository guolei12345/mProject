package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Type;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(String typeid);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String typeid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> selectAllType();
}