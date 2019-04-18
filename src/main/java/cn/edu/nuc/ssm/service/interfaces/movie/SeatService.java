package cn.edu.nuc.ssm.service.interfaces.movie;

import cn.edu.nuc.ssm.entity.movie.Seat;

public interface SeatService {
    int deleteByPrimaryKey(String seatid);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(String seatid);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);
}