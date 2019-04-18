package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.movie.Pic;

public interface PicService {
    int deleteByPrimaryKey(String picid);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(String picid);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}