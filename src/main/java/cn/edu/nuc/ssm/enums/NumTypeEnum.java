package cn.edu.nuc.ssm.enums;

public enum NumTypeEnum {
    手机号(1,"手机号"),
    邮箱(2,"邮箱"),
    用户名(3,"用户名"),
    其他(9,"其他");
    private int code;
    private String value;
    NumTypeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
    public static int getNumTypeCode(String name){
        return NumTypeEnum.valueOf(name).code;
    }
    public static String getNumTypeValue(int code){
        String vlu = "";
        for(NumTypeEnum numTypeEnum : NumTypeEnum.values()){
            if(numTypeEnum.code==code){
                vlu = numTypeEnum.value;
                break;
            }
        }
        return vlu;
    }
}