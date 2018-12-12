package cn.edu.nuc.ssm.webService.util;

import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebService;
import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceLocator;
import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType;

/**
 * 邮箱验证工具
 */
public class ValidateEmailService {
    public ValidateEmailWebService validateEmailWebService;

    private ValidateEmailWebServiceSoap_PortType validateEmailWebServiceSoap_portType;
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
}
