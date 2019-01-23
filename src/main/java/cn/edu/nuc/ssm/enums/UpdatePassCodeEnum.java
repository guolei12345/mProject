package cn.edu.nuc.ssm.enums;

import cn.edu.nuc.ssm.entity.Power;

public enum UpdatePassCodeEnum {
    修改密码成功(1,"修改密码成功"),
    修改密码失败(0,"修改密码失败，原因未知"),
    原始密码不正确(50,"原始密码不正确"),
    手机号或者邮箱格式不正确(10,"手机号已经被修改密码"),
    手机号或者邮箱未注册(40,"手机号已经被修改密码"),
    两次输入密码不一致(20,"两次输入密码不一致"),
    校验通过(100,"校验通过"),
    验证码不正确(30,"验证码不正确");
    private int code;
    private String value;
    UpdatePassCodeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
    public static int getUpdateCode(String name){
        return UpdatePassCodeEnum.valueOf(name).code;
    }
    public static String getUpdateValue(int code){
        String vlu = "";
        for(UpdatePassCodeEnum updatePassCodeEnum : UpdatePassCodeEnum.values()){
            if(updatePassCodeEnum.code==code){
                vlu = updatePassCodeEnum.value;
                break;
            }
        }
        return vlu;
    }
}