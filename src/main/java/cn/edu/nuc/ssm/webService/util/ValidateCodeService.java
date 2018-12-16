package cn.edu.nuc.ssm.webService.util;

import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebService;
import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceLocator;
import cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.rmi.RemoteException;

/**
 * 验证码工具类
 */
@Service
public abstract class ValidateCodeService {
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
     * 根据数字获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    public abstract byte[] smGetVerify(String code) throws RemoteException;

    /**
     * 根据英文获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    public abstract byte[] enGetVerify(String code) throws RemoteException;

    /**
     * 根据汉字获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    public abstract byte[] cnGetVerify(String code) throws RemoteException;
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

    /**
     * 图片到客户端
     * @param data
     * @param response
     */
    public void outPutToClient(byte[] data, HttpServletResponse response) throws Exception{
        try {
            response.setContentType("image/png");
            OutputStream outputStream = response.getOutputStream();
            InputStream inputStream = new ByteArrayInputStream(data);
            int len;  
            byte[] buf = new byte[1024];  
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            System.out.println("Make Picture success,Please find image in " + response);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
}
