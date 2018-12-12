/**
 * ValidateCodeWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.validateCode;

public interface ValidateCodeWebService extends javax.xml.rpc.Service {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>验证码图片 WEB 服务</strong>，输出PNG高品质格式的验证码图片和字节流，字符和字符之间的间距和高度随机产生，提高了验证码的安全性。<br
 * />此验证码图片Web Services请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */
    public java.lang.String getValidateCodeWebServiceSoapAddress();

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getValidateCodeWebServiceSoap12Address();

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
