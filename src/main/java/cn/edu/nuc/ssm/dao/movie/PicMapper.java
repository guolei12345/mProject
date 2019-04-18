package cn.edu.nuc.ssm.dao.movie;

import cn.edu.nuc.ssm.entity.movie.Pic;

public interface PicMapper {
    int deleteByPrimaryKey(String picid);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(String picid);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}