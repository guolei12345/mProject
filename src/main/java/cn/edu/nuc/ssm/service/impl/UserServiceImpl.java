package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.dao.PowerMapper;
import cn.edu.nuc.ssm.dao.UserMapper;
import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.service.interfaces.PowerService;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表操作的实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(String userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /**
     * 校验登陆状态
     * @param user
     * @return
     */
    @Override
    public boolean login(User user) {
        boolean loginFlag = false;
        String tell = user.getTell();
        User userLogin = userMapper.selectByTell(tell);
        if(userLogin != null && user.getPassword().equals(userLogin.getPassword())){
            loginFlag = true;
            user = userLogin;
        }
        return loginFlag;
    }


}
