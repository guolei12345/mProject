package cn.edu.nuc.ssm;

import cn.edu.nuc.ssm.enums.EmailCodeEnum;
import cn.edu.nuc.ssm.service.extend.ValidateEmailServiceSon;
import cn.edu.nuc.ssm.webService.util.ValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具
 */
public class CheckUtil {
    /**
     * 验证手机号格式
     *
     * @param phone 需要验证的电话号码字符串
     * @return true 正确 false 错误
     * @author 武尊
     * @version 1.0
     * @time 2016-12-30
     * @status 正常
     */
    public static ValidateEmailService validateEmailService;
    public static boolean isMobilephone(String phone) {
        if (phone.startsWith("86") || phone.startsWith("+86")) {
            phone = phone.substring(phone.indexOf("86") + 2);
        }
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean isEmail(String email){
        boolean flag = false;
        int rtn = getValidateEmailService().validateEmailAddress(email);
        if(rtn == EmailCodeEnum.getRegistCode(EmailCodeEnum.邮件地址合法.toString())){
            flag = true;
        }
        return flag;
    }

    public static ValidateEmailService getValidateEmailService(){
        if(validateEmailService == null){
            validateEmailService = new ValidateEmailServiceSon();
        }
        return validateEmailService;
    }
}
