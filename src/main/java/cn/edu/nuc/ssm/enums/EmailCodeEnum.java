package cn.edu.nuc.ssm.enums;

public enum EmailCodeEnum {
    邮件地址合法(1,"邮件地址合法"),
    请重新验证(0,"请重新验证"),
    只是域名正确(2,"只是域名正确"),
    一个未知错误(3,"一个未知错误"),
    邮件服务器没有找到(4,"邮件服务器没有找到"),
    电子邮件地址错误(5,"电子邮件地址错误"),
    免费用户验证超过数量(6,"免费用户验证超过数量"),
    商业用户不能通过验证(7,"商业用户不能通过验证");
    private int code;
    private String value;
    EmailCodeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
    public static int getRegistCode(String name){
        return EmailCodeEnum.valueOf(name).code;
    }
    public static String getRegistValue(int code){
        String vlu = "";
        for(EmailCodeEnum emailCodeEnum : EmailCodeEnum.values()){
            if(emailCodeEnum.code==code){
                vlu = emailCodeEnum.value;
                break;
            }
        }
        return vlu;
    }
}
