package cn.edu.nuc.ssm.enums;

public enum RegistCodeEnum {
    注册成功(1,"注册成功"),
    注册失败(0,"注册失败，原因未知"),
    手机号已经被注册(10,"手机号已经被注册"),
    两次输入密码不一致(20,"两次输入密码不一致"),
    手机号格式不正确(50,"手机号格式不正确"),
    用户编号为空(60,"用户编号为空"),
    不是正确的邮箱地址(70,"不是正确的邮箱地址"),
    校验通过(100,"校验通过"),
    验证码不正确(30,"验证码不正确");
    private int code;
    private String value;
    RegistCodeEnum(int code,String value){
        this.code = code;
        this.value = value;
    }
    public static int getRegistCode(String name){
        return RegistCodeEnum.valueOf(name).code;
    }
    public static String getRegistValue(int code){
        String vlu = "";
        for(RegistCodeEnum registCodeEnum : RegistCodeEnum.values()){
            if(registCodeEnum.code==code){
                vlu = registCodeEnum.value;
                break;
            }
        }
        return vlu;
    }
}