package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.dao.UserMapper;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.enums.EmailCodeEnum;
import cn.edu.nuc.ssm.enums.LoginCodeEnum;
import cn.edu.nuc.ssm.enums.RegistCodeEnum;
import cn.edu.nuc.ssm.enums.UpdatePassCodeEnum;
import cn.edu.nuc.ssm.logger.BaseLog;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import cn.edu.nuc.ssm.util.MailUtil;
import cn.edu.nuc.ssm.util.RedisUtil;
import cn.edu.nuc.ssm.util.StringUtil;
import cn.edu.nuc.ssm.webService.util.ValidateEmailService;
import org.hibernate.validator.constraints.Email;
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
    @Autowired
    ValidateEmailService validateEmailService;
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
    //发送验证码
    @Override
    public int sendCheck(String num) throws Exception {
        int rtn = 0;
        User user;
        String code = StringUtil.getCheckNum4();
        //如果是手机号发送短信验证码
        if(CheckUtil.isMobilephone(num)){
            //发送短信验证码
        }else if(CheckUtil.isEmail(num)){
            //发送邮箱验证码
            user = userMapper.selectByEmail(num);
            if(user == null){
                rtn = 3;
            }else {
                MailUtil.sendMail(user.getEmail(), "您好，修改密码，验证码：" + code);
                //设置缓存
                RedisUtil.getJedis().set(user.getEmail(), code);
            }
        }else{
            //不是邮箱也不是手机号
        }
        return rtn;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Override
    public int updatePassWord(User user) {
        int rtn = updateCheck(user);
        User updUser;
        //如果是手机号发送短信验证码
        if(CheckUtil.isMobilephone(user.getNum())){
            //发送短信验证码
            updUser = userMapper.selectByTell(user.getNum());
        }else if(CheckUtil.isEmail(user.getNum())){
            //发送邮箱验证码
            updUser = userMapper.selectByEmail(user.getNum());
        }else{
            //不是邮箱也不是手机号
            updUser = new User();
        }
        updUser.setPassword(user.getPassword());
        rtn = userMapper.updateByPrimaryKeySelective(updUser);
        return rtn;
    }

    /**
     * 修改密码校验
     * @param user
     * @return
     */
    private int updateCheck(User user) {
        logger.info("注册校验 start");
        int rtn = 0;
        String code = RedisUtil.getJedis().get(user.getNum());
        //验证码
        if(!code.equals(user.getCode())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.验证码不正确.toString());
        }

        if(!user.getNum().toUpperCase().equals(user.getCode().toUpperCase())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.验证码不正确.toString());
        }
        //是否是手机号&&是否是正确的邮箱
        else if(!CheckUtil.isMobilephone(user.getTell())&&!CheckUtil.isEmail(user.getEmail())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.手机号或者邮箱格式不正确.toString());
        }
        //两次密码不一致
        else if(!user.getPassword().equals(user.getPassword2())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.两次输入密码不一致.toString());
        }
        //查询手机号是否已经注册
        else{
            //查询手机号是否已经注册
            User tellUser = userMapper.selectByTell(user.getNum());
            User emailUser = userMapper.selectByEmail(user.getNum());
            if(tellUser == null && emailUser == null){
                rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.手机号或者邮箱未注册.toString());
            }else{
                rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.校验通过.toString());
            }
        }
        logger.info("注册校验 end ，结果："+ UpdatePassCodeEnum.getUpdateValue(rtn));
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
        //是否是正确的邮箱
        else if(!CheckUtil.isEmail(user.getEmail())){
            rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.不是正确的邮箱地址.toString());
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
                rtn = RegistCodeEnum.getRegistCode(RegistCodeEnum.校验通过.toString());
            }
        }
        logger.info("注册校验 end ，结果："+ RegistCodeEnum.getRegistValue(rtn));
        return rtn;
    }

}
