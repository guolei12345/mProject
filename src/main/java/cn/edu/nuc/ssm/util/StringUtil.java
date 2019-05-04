package cn.edu.nuc.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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

    public static Date StringToDate(String time) {
        //注意：SimpleDateFormat构造函数的样式与time的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
        Date date=null;
        //必须捕获异常
        try {
            date=simpleDateFormat.parse(time);
            System.out.println(date);
        } catch(Exception px) {
            px.printStackTrace();
        }
        return date;
    }

    public static String removeStr(String col, String setnum) {
        String colum = col.replaceFirst("-"+setnum,"");
        return colum;
    }

    /**
     * 找到数量最大的key
     * @param typeNum
     * @return
     */
    public static String findMaxType(Map<String, Integer> typeNum) {
        String maxType = "";
        int num = 0;
        if(typeNum!=null){
            for(String key:typeNum.keySet()){
                int tem = typeNum.get(key);
                if(tem>num){
                    num = tem;
                    maxType = key;
                }
            }
        }
        return maxType;
    }
}
