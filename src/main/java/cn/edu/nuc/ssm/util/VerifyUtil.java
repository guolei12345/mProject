package cn.edu.nuc.ssm.util;

import java.util.Random;

public class VerifyUtil {

    /**
     * 获取随机验证码第一种方法
     * @return
     */
    public static String getVerifyCode1(){
        String str = "";
        char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random random = new Random();
        for (int i = 0; i <4; i++){
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;
    }
    /**
     * 获取随机验证码第一种方法
     * @return
     */
    public static String getVerifyCode2(){
        Random random = new Random();
        char[] set = {91,92,93,94,95,96,58,59,60,61,62,63,64};
        String str = "";
        while (str.length() != 6){
            boolean flag = true;
            int a = (random.nextInt(75) + 48);
            for (int j = 0; j < set.length; j++){
                if (a == set[j]){
                    flag = false;
                }
            }
            if (flag){
                char ch = (char) a;
                //System.out.println(a);
                str += ch;
            }
        }
        return str;
    }
    public static String getVerifyCode3() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 6; i++){
            int key = random.nextInt(3);
            switch (key){
                case 0:
                    int code1 = random.nextInt(10);
                    str += code1;
                    break;
                case 1:
                    char code2 = (char)(random.nextInt(26)+65);
                    str += code2;
                    break;
                case 2:
                    char code3 = (char)(random.nextInt(26)+97);
                    str += code3;
                    break;
            }
        }
        return str;
    }
}
