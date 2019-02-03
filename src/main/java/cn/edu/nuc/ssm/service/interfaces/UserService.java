package cn.edu.nuc.ssm.service.interfaces;

import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int login(User user, String code, HttpSession session);

    int regist(User user,String code);

    int sendCheck(String num) throws Exception;

    int updatePassWord(User user, boolean hasOld);

    List<User> selectAllUser();

    void resetUser(HttpSession session,String tell);

    int deleteUser(String userid);

    int saveUser(User user);

    PageInfo<User> selectAllUserByKey(String key,int current,int offset);
}