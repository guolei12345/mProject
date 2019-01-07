package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.dao.PowerMapper;
import cn.edu.nuc.ssm.dao.UserMapper;
import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.logger.BaseLog;
import cn.edu.nuc.ssm.service.interfaces.PowerService;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 用户表操作的实现类
 */
@Service
public class UserServiceImpl extends BaseLog implements UserService {
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
    public int login(User user, String code, HttpSession session) {
        //登陆结果code
        int rtn = loginCheck(user,code);
        //校验通过
        if(rtn ==  LoginCodeEnum.getLoginCode(LoginCodeEnum.校验通过.toString())){
            logger.info("登陆 start info：{}",user.toString());
            User userInfo = userMapper.selectByTell(user.getTell());
            //有该手机号
            if(userInfo!=null){
                //密码校验
                if(!user.getPassword().equals(userInfo.getPassword())){
                    rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.手机号格式不正确.toString());
                }else{
                    session.setAttribute("user",userInfo);
                    rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.登陆成功.toString());
                }
            }else{
                rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.手机号未注册.toString());
            }
        }
        logger.info("登陆end info：{}",LoginCodeEnum.getLoginValue(rtn));
        return rtn;
    }

    /**
     * 登陆校验
     * @param user
     * @param code
     * @return
     */
    private int loginCheck(User user, String code) {
        logger.info("登陆校验 start");
        int rtn = 0;
        //验证码
        if(!code.toUpperCase().equals(user.getCode().toUpperCase())){
            rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.验证码不正确.toString());
        }
        //是否是手机号
        else if(!CheckUtil.isMobilephone(user.getTell())){
            rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.手机号格式不正确.toString());
        }
        else {
            rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.校验通过.toString());
        }
        logger.info("登陆校验 end ，结果："+ LoginCodeEnum.getLoginValue(rtn));
        return rtn;
    }

    /**
     * 用户注册
     * @param user
     * @return
     * 返回1  表示注册成功
     * 返回100 表示手机号已注册
     * 返回其它 暂时没有出现
     */
    @Override
    public int regist(User user, String code) {
        //注册结果code
        int rtn = registCheck(user,code);
        if(rtn == RegistCodeEnum.getRegistCode(RegistCodeEnum.校验通过.toString())){
            //查看用户UUID是否为空
            boolean idFlag = StringUtil.isNotEmpty(user.getUserid());
            //如果没有userID 生成随机ID 并赋值
            if(!idFlag){
                String userId = StringUtil.getUUId();
                user.setUserid(userId);
            }
            logger.info("注册 start info：{}",user.toString());
            rtn = userMapper.insertSelective(user);
            if(rtn>0){
                rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.注册成功.toString());
            }else{
                rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.注册失败.toString());
            }
        }
        logger.info("注册end info：{}",RegistCodeEnum.getRegistValue(rtn));
        return rtn;
    }

    /**
     * 注册校验
     * @param user
     * @param code
     * @return
     */
    private int registCheck(User user, String code) {
        logger.info("注册校验 start");
        int rtn = 0;
        //验证码
        if(!code.toUpperCase().equals(user.getCode().toUpperCase())){
            rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.验证码不正确.toString());
        }
        //是否是手机号
        else if(!CheckUtil.isMobilephone(user.getTell())){
            rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.手机号格式不正确.toString());
        }
        //两次密码不一致
        else if(!user.getPassword().equals(user.getPassword2())){
            rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.两次输入密码不一致.toString());
        }
        //查询手机号是否已经注册
        else{
            //查询手机号是否已经注册
            User oldUser = userMapper.selectByTell(user.getTell());
            if(oldUser != null){
                rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.手机号已经被注册.toString());
            }else{
                rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.注册成功.toString());
            }
        }
        logger.info("注册校验 end ，结果："+ RegistCodeEnum.getRegistValue(rtn));
        return rtn;
    }

}
