package cn.edu.nuc.ssm.util;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
public class PhoneUtil {

    public static void sendCode(String code) throws Exception{
        HttpClient client = new HttpClient();
        //http://utf8.api.smschinese.cn/
        //http://gbk.api.smschinese.cn
        PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "guolei1"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","18435186589"),new NameValuePair("smsText","验证码："+code+"【个人中心】")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        System.out.println(result); //打印返回消息状态
        post.releaseConnection();
    }
}
