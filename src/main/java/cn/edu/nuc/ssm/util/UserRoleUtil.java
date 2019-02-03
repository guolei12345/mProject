package cn.edu.nuc.ssm.util;

import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.entity.UserRole;

public class UserRoleUtil {
    /**
     * 封装UserRole 信息
     * 将用户信息中的 userid roleid封装到对象中
     * 随机生成id设置为 id
     *
     * 如果用户信息中的 userid roleid 有一个为空，
     * 返回的UserRole 信息中没有这两个字段的值
     * @param user
     * @return
     */
    public static UserRole getUserRole(User user){
        UserRole userRole;
        if(user != null &&!StringUtil.isNotEmpty(user.getUserid())&&!StringUtil.isNotEmpty(user.getRoleid())){
            userRole = new UserRole();
            userRole.setId(StringUtil.getUUId());
            userRole.setUserid(user.getUserid());
            userRole.setRoleid(user.getRoleid());
        }else{
            userRole = new UserRole();
            userRole.setId(StringUtil.getUUId());
        }
        return userRole;
    }
}
