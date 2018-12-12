/**
 * ValidateEmailWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.alidateEmail;

public interface ValidateEmailWebService extends javax.xml.rpc.Service {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>Email地址验证 WEB 服务</strong>，通过查找给定的电子邮件域的邮件服务器和通过向邮件服务器发送数据来判断电子邮件地址正确与否。此Email地址验证Web
 * Service请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */
    public java.lang.String getValidateEmailWebServiceSoapAddress();

    public ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getValidateEmailWebServiceSoap12Address();

    public ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
