/**
 * ValidateEmailWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.alidateEmail;

public class ValidateEmailWebServiceLocator extends org.apache.axis.client.Service implements cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebService {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>Email地址验证 WEB 服务</strong>，通过查找给定的电子邮件域的邮件服务器和通过向邮件服务器发送数据来判断电子邮件地址正确与否。此Email地址验证Web
 * Service请不要用于任何商业目的，若有需要请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
 * target="_blank">联系我们</a>，欢迎技术交流。 QQ：8409035<br /><strong>使用本站 WEB
 * 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持</strong>！<br /><br />&nbsp;
 */

    public ValidateEmailWebServiceLocator() {
    }


    public ValidateEmailWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ValidateEmailWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ValidateEmailWebServiceSoap
    private java.lang.String ValidateEmailWebServiceSoap_address = "http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx";

    public java.lang.String getValidateEmailWebServiceSoapAddress() {
        return ValidateEmailWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidateEmailWebServiceSoapWSDDServiceName = "ValidateEmailWebServiceSoap";

    public java.lang.String getValidateEmailWebServiceSoapWSDDServiceName() {
        return ValidateEmailWebServiceSoapWSDDServiceName;
    }

    public void setValidateEmailWebServiceSoapWSDDServiceName(java.lang.String name) {
        ValidateEmailWebServiceSoapWSDDServiceName = name;
    }

    public cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidateEmailWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidateEmailWebServiceSoap(endpoint);
    }

    public cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_BindingStub _stub = new cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getValidateEmailWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidateEmailWebServiceSoapEndpointAddress(java.lang.String address) {
        ValidateEmailWebServiceSoap_address = address;
    }


    // Use to get a proxy class for ValidateEmailWebServiceSoap12
    private java.lang.String ValidateEmailWebServiceSoap12_address = "http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx";

    public java.lang.String getValidateEmailWebServiceSoap12Address() {
        return ValidateEmailWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidateEmailWebServiceSoap12WSDDServiceName = "ValidateEmailWebServiceSoap12";

    public java.lang.String getValidateEmailWebServiceSoap12WSDDServiceName() {
        return ValidateEmailWebServiceSoap12WSDDServiceName;
    }

    public void setValidateEmailWebServiceSoap12WSDDServiceName(java.lang.String name) {
        ValidateEmailWebServiceSoap12WSDDServiceName = name;
    }

    public cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidateEmailWebServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidateEmailWebServiceSoap12(endpoint);
    }

    public cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType getValidateEmailWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap12Stub _stub = new cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getValidateEmailWebServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidateEmailWebServiceSoap12EndpointAddress(java.lang.String address) {
        ValidateEmailWebServiceSoap12_address = address;
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
            if (cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_BindingStub _stub = new cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_BindingStub(new java.net.URL(ValidateEmailWebServiceSoap_address), this);
                _stub.setPortName(getValidateEmailWebServiceSoapWSDDServiceName());
                return _stub;
            }
            if (cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap12Stub _stub = new cn.edu.nuc.ssm.webService.alidateEmail.ValidateEmailWebServiceSoap12Stub(new java.net.URL(ValidateEmailWebServiceSoap12_address), this);
                _stub.setPortName(getValidateEmailWebServiceSoap12WSDDServiceName());
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
        if ("ValidateEmailWebServiceSoap".equals(inputPortName)) {
            return getValidateEmailWebServiceSoap();
        }
        else if ("ValidateEmailWebServiceSoap12".equals(inputPortName)) {
            return getValidateEmailWebServiceSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateEmailWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateEmailWebServiceSoap"));
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "ValidateEmailWebServiceSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ValidateEmailWebServiceSoap".equals(portName)) {
            setValidateEmailWebServiceSoapEndpointAddress(address);
        }
        else 
if ("ValidateEmailWebServiceSoap12".equals(portName)) {
            setValidateEmailWebServiceSoap12EndpointAddress(address);
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
