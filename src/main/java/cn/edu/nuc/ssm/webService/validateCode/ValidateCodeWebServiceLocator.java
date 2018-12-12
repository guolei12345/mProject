/**
 * ValidateCodeWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.validateCode;

public class ValidateCodeWebServiceLocator extends org.apache.axis.client.Service implements cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebService {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>验证码图片 WEB 服务</strong>，输出PNG高品质格式的验证码图片和字节流，字符和字符之间的间距和高度随机产生，提高了验证码的安全性。<br
 * />此验证码图片Web Services请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */

    public ValidateCodeWebServiceLocator() {
    }


    public ValidateCodeWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ValidateCodeWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ValidateCodeWebServiceSoap
    private java.lang.String ValidateCodeWebServiceSoap_address = "http://www.webxml.com.cn/WebServices/ValidateCodeWebService.asmx";

    public java.lang.String getValidateCodeWebServiceSoapAddress() {
        return ValidateCodeWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidateCodeWebServiceSoapWSDDServiceName = "ValidateCodeWebServiceSoap";

    public java.lang.String getValidateCodeWebServiceSoapWSDDServiceName() {
        return ValidateCodeWebServiceSoapWSDDServiceName;
    }

    public void setValidateCodeWebServiceSoapWSDDServiceName(java.lang.String name) {
        ValidateCodeWebServiceSoapWSDDServiceName = name;
    }

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidateCodeWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidateCodeWebServiceSoap(endpoint);
    }

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_BindingStub _stub = new cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getValidateCodeWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidateCodeWebServiceSoapEndpointAddress(java.lang.String address) {
        ValidateCodeWebServiceSoap_address = address;
    }


    // Use to get a proxy class for ValidateCodeWebServiceSoap12
    private java.lang.String ValidateCodeWebServiceSoap12_address = "http://www.webxml.com.cn/WebServices/ValidateCodeWebService.asmx";

    public java.lang.String getValidateCodeWebServiceSoap12Address() {
        return ValidateCodeWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidateCodeWebServiceSoap12WSDDServiceName = "ValidateCodeWebServiceSoap12";

    public java.lang.String getValidateCodeWebServiceSoap12WSDDServiceName() {
        return ValidateCodeWebServiceSoap12WSDDServiceName;
    }

    public void setValidateCodeWebServiceSoap12WSDDServiceName(java.lang.String name) {
        ValidateCodeWebServiceSoap12WSDDServiceName = name;
    }

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidateCodeWebServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidateCodeWebServiceSoap12(endpoint);
    }

    public cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType getValidateCodeWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap12Stub _stub = new cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getValidateCodeWebServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidateCodeWebServiceSoap12EndpointAddress(java.lang.String address) {
        ValidateCodeWebServiceSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_BindingStub _stub = new cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_BindingStub(new java.net.URL(ValidateCodeWebServiceSoap_address), this);
                _stub.setPortName(getValidateCodeWebServiceSoapWSDDServiceName());
                return _stub;
            }
            if (cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap12Stub _stub = new cn.edu.nuc.ssm.webService.validateCode.ValidateCodeWebServiceSoap12Stub(new java.net.URL(ValidateCodeWebServiceSoap12_address), this);
                _stub.setPortName(getValidateCodeWebServiceSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ValidateCodeWebServiceSoap".equals(inputPortName)) {
            return getValidateCodeWebServiceSoap();
        }
        else if ("ValidateCodeWebServiceSoap12".equals(inputPortName)) {
            return getValidateCodeWebServiceSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateCodeWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateCodeWebServiceSoap"));
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateCodeWebServiceSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ValidateCodeWebServiceSoap".equals(portName)) {
            setValidateCodeWebServiceSoapEndpointAddress(address);
        }
        else 
if ("ValidateCodeWebServiceSoap12".equals(portName)) {
            setValidateCodeWebServiceSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
