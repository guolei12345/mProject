package cn.edu.nuc.ssm.service.extend;

import cn.edu.nuc.ssm.webService.util.ValidateEmailService;
import org.apache.axis.types.UnsignedByte;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

@Service
public class ValidateEmailServiceSon extends ValidateEmailService {
    public ValidateEmailServiceSon(){
        try {
            validateEmailWebServiceSoap_portType = getValidateEmailWebServiceSoap_portType();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int validateEmailAddress(String theEmail){
        UnsignedByte unsignedByte = null;
        try {
            unsignedByte = validateEmailWebServiceSoap_portType.validateEmailAddress(theEmail);
        } catch (RemoteException e) {
            e.printStackTrace();
            unsignedByte.setValue(0);
        }
        return unsignedByte.intValue();
    }

    @Override
    public int validateEmailAddressPro(String theEmail, int theEmailPort) throws RemoteException {
        UnsignedByte unsignedByte = validateEmailWebServiceSoap_portType.validateEmailAddressPro(theEmail, theEmailPort);
        return unsignedByte.intValue();
    }
}
