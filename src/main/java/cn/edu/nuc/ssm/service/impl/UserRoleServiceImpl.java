package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.dao.UserMapper;
import cn.edu.nuc.ssm.dao.UserRoleMapper;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.entity.UserRole;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.NumTypeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.enums.UpdatePassCodeEnum;
import cn.edu.nuc.ssm.logger.BaseLog;
import cn.edu.nuc.ssm.service.interfaces.UserRoleService;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.MailUtil;
import cn.edu.nuc.ssm.util.PhoneUtil;
import cn.edu.nuc.ssm.util.RedisUtil;
import cn.edu.nuc.ssm.util.StringUtil;
import cn.edu.nuc.ssm.webService.util.ValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

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
            userRole = new UserRole();
            userRole.setId(StringUtil.getUUId());
            userRole.setUserid(user.getUserid());
            userRole.setRoleid(user.getRoleid());
            rtn = userRoleMapper.insertSelective(userRole);
        }else{
            userRole.setRoleid(user.getRoleid());
            rtn = userRoleMapper.updateByPrimaryKeySelective(userRole);
        }
        return rtn;
    }

}
