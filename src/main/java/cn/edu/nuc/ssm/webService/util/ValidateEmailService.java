package cn.edu.nuc.ssm.webService.util;

import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebService;
import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceLocator;
import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType;

/**
 * 邮箱验证工具
 */
public abstract class ValidateEmailService {

    public ValidateEmailWebService validateEmailWebService;
    public ValidateEmailWebServiceSoap_PortType validateEmailWebServiceSoap_portType;
    public ValidateEmailService(){
        validateEmailWebService = new ValidateEmailWebServiceLocator();
    }

    /**
     * 获取ValidateEmailWebServiceSoap_PortType的接口调用
     * @return
     * @throws javax.xml.rpc.ServiceException
     */
    public ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap_portType() throws javax.xml.rpc.ServiceException {
        if(validateEmailWebService == null){
            validateEmailWebService = new ValidateEmailWebServiceLocator();
        }
        validateEmailWebServiceSoap_portType = validateEmailWebService.getValidateEmailWebServiceSoap12();
        if(validateEmailWebServiceSoap_portType == null){
            validateEmailWebServiceSoap_portType = validateEmailWebService.getValidateEmailWebServiceSoap12();
        }
        return validateEmailWebServiceSoap_portType;
    }
    /**
     * <br /><h3>验证 Email 地址是否正确</h3><p>输入参数：EmailAddress = Email
     * 地址（默认SMTP端口25），返回数据： Byte 字节。返回值： 0 = 请重新验证；1 = 邮件地址合法；2 = 只是域名正确；3
     * = 一个未知错误；4 = 邮件服务器没有找到；5 = 电子邮件地址错误；6 = 免费用户验证超过数量（50次/24小时）；7 = 商业用户不能通过验证</p><br
     * />
     */
    public abstract int validateEmailAddress(java.lang.String theEmail);

    /**
     * <br /><h3>验证 Email 地址是否正确</h3><p>输入参数：EmailAddress = Email
     * 地址，theEmailPort = SMTP端口（Integer），返回数据： Byte 字节。返回值同 ValidateEmailAddress</p><br
     * />
     */
    public abstract int validateEmailAddressPro(java.lang.String theEmail, int theEmailPort) throws java.rmi.RemoteException;

}
