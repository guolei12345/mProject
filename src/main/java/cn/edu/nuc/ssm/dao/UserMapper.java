package cn.edu.nuc.ssm.dao;

import cn.edu.nuc.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByTell(String tell);

    User selectByEmail(String email);

    List<User> selectAllUser();

    int selectUserCount();

    List<User> selectUserByKey(@Param(value = "key")String key, @Param(value = "start")int start, @Param(value = "offset")int offset);
}