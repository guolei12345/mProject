package cn.edu.nuc.ssm.service.extend;

import cn.edu.nuc.ssm.webService.util.ValidateCodeService;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class ValidateCodeServiceSon extends ValidateCodeService {
    /**
     * 根据数字获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    @Override
    public byte[] smGetVerify(String code) throws RemoteException {
        return validateCodeWebServiceSoap_portType.smallValidateByte(code);
    }

    /**
     * 根据英文获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    @Override
    public byte[] enGetVerify(String code) throws RemoteException {
        return validateCodeWebServiceSoap_portType.enValidateByte(code);
    }

    /**
     * 根据汉字获取验证码
     * @param code
     * @return
     * @throws RemoteException
     */
    @Override
    public byte[] cnGetVerify(String code) throws RemoteException {
        return validateCodeWebServiceSoap_portType.cnValidateByte(code);
    }

}
