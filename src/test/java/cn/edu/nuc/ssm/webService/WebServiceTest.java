package cn.edu.nuc.ssm.webService;

import cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType;
import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import cn.edu.nuc.ssm.webService.util.ValidateEmailService;
import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType;
import org.apache.axis.types.UnsignedByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;

/**
 * webService Test
 */
public class WebServiceTest {
    public static Logger logger = LoggerFactory.getLogger(WebServiceTest.class);
    public static void main(String[] args) throws javax.xml.rpc.ServiceException, RemoteException {
        //手机号校验
        ValidateEmailService validateEmailService = new ValidateEmailService();
        ValidateEmailWebServiceSoap_PortType validateEmailWebServiceSoap_portType = validateEmailService.getValidateEmailWebServiceSoap_portType();
        UnsignedByte unsignedByte = validateEmailWebServiceSoap_portType.validateEmailAddress("240372795@qq.com");
        int rtn = Integer.parseInt(unsignedByte.toString());
        logger.info(unsignedByte.toString());

        // 图片校验
        ValidateCodeService validateCodeService = new ValidateCodeService();
        ValidateCodeWebServiceSoap_PortType validateCodeWebServiceSoap_PortType = validateCodeService.getValidateCodeWebServiceSoap_portType();
        byte[] bytes = validateCodeWebServiceSoap_PortType.cnValidateByte("中国");
        validateCodeService.byte2image(bytes,"E:\\code\\中国.jpg");
        //validateCodeWebServiceSoap_PortType.cnValidateImage("2345");
        byte[] bytes2 = validateCodeWebServiceSoap_PortType.enValidateByte("China");
        validateCodeService.byte2image(bytes2,"E:\\code\\china.jpg");

        byte[] bytes3 = validateCodeWebServiceSoap_PortType.smallValidateByte("2342353");
        validateCodeService.byte2image(bytes3,"E:\\code\\code.jpg");
    }
}
