package cn.edu.nuc.ssm.util;


import java.io.*;
import java.util.Properties;

/**
 * Desc:properties文件获取工具类
 * Created by
 */
public class PropertyUtil {
    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        props = new Properties();
        InputStream in = null;
        try {
            //第一种，通过类加载器进行获取properties文件流
            //in = PropertyUtil.class.getClassLoader().getResourceAsStream("sysConfig.properties");
            //第二种，通过类进行获取properties文件流
            in = PropertyUtil.class.getResourceAsStream("/config/kaiguan.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            //logger.error("sysConfig.properties文件未找到");
        } catch (IOException e) {
            //logger.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                //logger.error("sysConfig.properties文件流关闭出现异常");
            }
        }
        //logger.info("加载properties文件内容完成...........");
        //logger.info("properties文件内容：" + props);
    }
    public static boolean getPropertyBool(String key) {
        boolean flag = false;
        if (null == props) {
            loadProps();
        }
        String str = props.getProperty(key);
        if("TURE".equals(str.toUpperCase())){
            flag = true;
        }
        return flag;
    }
    public static boolean getPropertyBool(String key, String defaultValue) {
        boolean flag = false;
        if (null == props) {
            loadProps();
        }
        String str = props.getProperty(key, defaultValue);
        if("TURE".equals(str.toUpperCase())){
            flag = true;
        }
        return flag;
    }
    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}