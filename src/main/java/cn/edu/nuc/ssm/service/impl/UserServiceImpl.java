package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.CheckUtil;
import cn.edu.nuc.ssm.dao.UserMapper;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.enums.*;
import cn.edu.nuc.ssm.logger.BaseLog;
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
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
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
            User userInfo;
            if(getNumType(user.getNum())==NumTypeEnum.手机号){
                userInfo = userMapper.selectByTell(user.getNum());
            }else{
                userInfo = userMapper.selectByEmail(user.getNum());
            }
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
                rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.用户名不正确.toString());
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
        else if(getNumType(user.getNum()) == NumTypeEnum.其他){
            rtn = LoginCodeEnum.getLoginCode(LoginCodeEnum.用户名不正确.toString());
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
        if(getNumType(num) == NumTypeEnum.手机号){
            //发送短信验证码
            user = userMapper.selectByTell(num);
            if(user == null){
                rtn = 4;
            }else{
                PhoneUtil.sendCode(code);
            }
        }else if(getNumType(num) == NumTypeEnum.邮箱){
            //发送邮箱验证码
            user = userMapper.selectByEmail(num);
            if(user == null){
                rtn = 3;
            }else {
                MailUtil.sendMail(user.getEmail(), "pleast input code:" + code);
            }
        }else{
            //不是邮箱也不是手机号
        }
        //设置缓存
        RedisUtil.getJedis().set(num, code);
        return rtn;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Override
    public int updatePassWord(User user,boolean hasOld) {
        int rtn = updateCheck(user,hasOld);
        User updUser = null;
        if(rtn == UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.校验通过.toString())){
            //如果是手机号发送短信验证码
            NumTypeEnum numTypeEnum = getNumType(user.getNum());
            if(numTypeEnum == NumTypeEnum.手机号){
                //根据电话号查询用户
                updUser = userMapper.selectByTell(user.getNum());
            }else if(numTypeEnum == NumTypeEnum.邮箱){
                //根据邮箱查询用户
                updUser = userMapper.selectByEmail(user.getNum());
            }else{
                user = null;
            }
            if(updUser == null){
                rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.手机号或者邮箱未注册.toString());
            }else{
                //如果用旧密码修改
                if(hasOld){
                    if(user.getPassword().equals(updUser.getPassword())){
                        updUser.setPassword(user.getPassword2());
                        rtn = userMapper.updateByPrimaryKeySelective(updUser);
                    }else{
                        rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.原始密码不正确.toString());
                    }
                }else{
                    updUser.setPassword(user.getPassword2());
                    rtn = userMapper.updateByPrimaryKeySelective(updUser);
                }
            }
        }else{

        }
        return rtn;
    }

    /**
     * 判断用户输入的是手机号、邮箱、用户名
     * @param num
     * @return
     */
    public NumTypeEnum getNumType(String num){
        NumTypeEnum numTypeEnum;
        //如果是手机号发送短信验证码
        if(CheckUtil.isMobilephone(num)){
            //num为手机号
            numTypeEnum = NumTypeEnum.手机号;
        }else if(CheckUtil.isEmail(num)){
            //num为手机号
            numTypeEnum = NumTypeEnum.邮箱;
        }else{
            //不是邮箱也不是手机号
            numTypeEnum = NumTypeEnum.其他;
        }
        return numTypeEnum;
    }

    /**
     * 修改密码校验
     * @param user
     * @return
     */
    private int updateCheck(User user,boolean hasOld) {
        logger.info("注册校验 start");
        int rtn = 0;
        String code = RedisUtil.getJedis().get(user.getNum());
        //验证码
        if(!hasOld&&!code.equals(user.getCode())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.验证码不正确.toString());
        }
        //是否是手机号&&是否是正确的邮箱
        else if(!CheckUtil.isMobilephone(user.getNum())&&!CheckUtil.isEmail(user.getNum())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.手机号或者邮箱格式不正确.toString());
        }
        //两次密码不一致
        else if(!user.getPassword3().equals(user.getPassword2())){
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.两次输入密码不一致.toString());
        }
        //查询手机号是否已经注册
        else{
            rtn = UpdatePassCodeEnum.getUpdateCode(UpdatePassCodeEnum.校验通过.toString());
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
