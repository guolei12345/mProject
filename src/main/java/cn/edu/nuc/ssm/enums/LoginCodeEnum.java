package cn.edu.nuc.ssm.enums;

public enum LoginCodeEnum {
    登陆成功(1,"登陆成功"),
    登陆失败(0,"登陆失败，原因未知"),
    手机号格式不正确(50,"手机号格式不正确"),
    手机号未注册(20,"手机号未注册"),
    密码不正确(60,"密码不正确"),
    校验通过(100,"校验通过"),
    用户名不正确(30,"用户名不正确"),
    验证码不正确(30,"验证码不正确");
    private int code;
    private String value;
    LoginCodeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
    public static int getLoginCode(String name){
        return LoginCodeEnum.valueOf(name).code;
    }
    public static String getLoginValue(int code){
        String vlu = "";
        for(LoginCodeEnum registCodeEnum : LoginCodeEnum.values()){
            if(registCodeEnum.code==code){
                vlu = registCodeEnum.value;
                break;
            }
        }
        return vlu;
    }
}