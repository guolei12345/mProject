package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Advise;

public interface AdviseMapper {
    int deleteByPrimaryKey(String adviseid);

    int insert(Advise record);

    int insertSelective(Advise record);

    Advise selectByPrimaryKey(String adviseid);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);
}