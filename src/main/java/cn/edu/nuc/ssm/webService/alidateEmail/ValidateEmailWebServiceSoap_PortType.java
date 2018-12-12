/**
 * ValidateEmailWebServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.alidateEmail;

public interface ValidateEmailWebServiceSoap_PortType extends java.rmi.Remote {

    /**
     * <br /><h3>验证 Email 地址是否正确</h3><p>输入参数：EmailAddress = Email
     * 地址（默认SMTP端口25），返回数据： Byte 字节。返回值： 0 = 请重新验证；1 = 邮件地址合法；2 = 只是域名正确；3
     * = 一个未知错误；4 = 邮件服务器没有找到；5 = 电子邮件地址错误；6 = 免费用户验证超过数量（50次/24小时）；7 = 商业用户不能通过验证</p><br
     * />
     */
    public org.apache.axis.types.UnsignedByte validateEmailAddress(java.lang.String theEmail) throws java.rmi.RemoteException;

    /**
     * <br /><h3>验证 Email 地址是否正确</h3><p>输入参数：EmailAddress = Email
     * 地址，theEmailPort = SMTP端口（Integer），返回数据： Byte 字节。返回值同 ValidateEmailAddress</p><br
     * />
     */
    public org.apache.axis.types.UnsignedByte validateEmailAddressPro(java.lang.String theEmail, int theEmailPort) throws java.rmi.RemoteException;
}
