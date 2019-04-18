package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.movie.Type;

import java.util.List;

public interface TypeService {
    int deleteByPrimaryKey(String typeid);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String typeid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> selectAllType();
}