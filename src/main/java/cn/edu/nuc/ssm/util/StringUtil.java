package cn.edu.nuc.ssm.util;

import java.util.Random;
import java.util.UUID;

public class StringUtil {
    public static String getUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
    /**
     * 校验字符串是否为空
     * 如果为空/空字符串  返回true
     * 否则返回 false
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        boolean flag = false;
        if(null != str && !"".equals(str)){
            flag = true;
        }
        return flag;
    }

    /**
     * 获取4位随机验证码
     * @return
     */
    public static String getCheckNum4(){
        return String.valueOf((new Random().nextInt(8999) + 1000));
    }
    /**
     * 获取6位随机验证码
     * @return
     */
    public static String getCheckNum6(){
        return String.valueOf((new Random().nextInt(899999) + 100000));
    }
}
