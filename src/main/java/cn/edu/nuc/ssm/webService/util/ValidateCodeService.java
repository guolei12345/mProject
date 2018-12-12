package cn.edu.nuc.ssm.webService.util;

import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebService;
import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceLocator;
import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType;

import javax.imageio.stream.FileImageOutputStream;
import javax.xml.rpc.ServiceException;
import java.io.File;
import java.util.Random;

/**
 * 验证码工具类
 */
public class ValidateCodeService {
    public ValidateCodeWebService validateCodeWebService;
    public ValidateCodeWebServiceSoap_PortType validateCodeWebServiceSoap_portType;

    public ValidateCodeService(){
        validateCodeWebService = new ValidateCodeWebServiceLocator();
    }
    public ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap_portType() throws ServiceException {
        if(validateCodeWebService == null){
            validateCodeWebService = new ValidateCodeWebServiceLocator();
        }
        validateCodeWebServiceSoap_portType = validateCodeWebService.getValidateCodeWebServiceSoap();
        if(validateCodeWebServiceSoap_portType == null){
            validateCodeWebServiceSoap_portType = validateCodeWebService.getValidateCodeWebServiceSoap12();
        }
        return validateCodeWebServiceSoap_portType;
    }

    /**
     * 数组到图片的转换
     * @param data
     * @param path
     */
    public void byte2image(byte[] data,String path) {
    if (data.length < 3 || path.equals(""))
        return;
    try {
        FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
        imageOutput.write(data, 0, data.length);
        imageOutput.close();
        System.out.println("Make Picture success,Please find image in " + path);
    } catch (Exception ex) {
        System.out.println("Exception: " + ex);
        ex.printStackTrace();
    }
    }
}
