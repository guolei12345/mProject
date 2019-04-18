package cn.edu.nuc.ssm.service.impl.power;

import cn.edu.nuc.ssm.dao.power.UserRoleMapper;
import cn.edu.nuc.ssm.entity.power.User;
import cn.edu.nuc.ssm.entity.power.UserRole;
import cn.edu.nuc.ssm.logger.BaseLog;
import cn.edu.nuc.ssm.service.interfaces.power.UserRoleService;
import cn.edu.nuc.ssm.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表操作的实现类
 */
@Service
public class UserRoleServiceImpl extends BaseLog implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public UserRole selectByPrimaryKey(String id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserRole selectByUserId(String userid) {
        return userRoleMapper.selectByUserId(userid);
    }

    @Override
    public int saveOrUpdateUserRole(User user) {
        int rtn = 0;
        UserRole userRole = userRoleMapper.selectByUserId(user.getUserid());
        if(userRole == null ||"".equals(userRole.getId())){
            //调用封装数据的工具
            userRole = UserRoleUtil.getUserRole(user);
            rtn = userRoleMapper.insertSelective(userRole);
        }else{
            userRole.setRoleid(user.getRoleid());
            rtn = userRoleMapper.updateByPrimaryKeySelective(userRole);
        }
        return rtn;
    }

}
