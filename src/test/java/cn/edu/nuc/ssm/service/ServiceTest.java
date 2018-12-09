package cn.edu.nuc.ssm.service;

import cn.edu.nuc.ssm.BaseTest;
import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.service.interfaces.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

public class ServiceTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void userTest(){
        User user = userService.selectByPrimaryKey("0OO25F3B7PTG CCFTBLMT4NYI4E8ND");
        logger.info("select user :"+user.toString());
        user.setUsername("guolei");
        logger.info("select user :"+user.toString());
        int rtn = userService.updateByPrimaryKey(user);
        logger.info("rtn :"+rtn);
        User upduser = userService.selectByPrimaryKey("0OO25F3B7PTG CCFTBLMT4NYI4E8ND");
        logger.info("upduser :"+upduser.toString());
        user.setPassword("123456");
        userService.updateByPrimaryKeySelective(user);

    }

}
