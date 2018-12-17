/**
 * MobileCodeWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.mobil;

public interface MobileCodeWS extends javax.xml.rpc.Service {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>国内手机号码归属地查询WEB服务</strong>，提供最新的国内手机号码段归属地数据，每月更新。<br />使用本站
 * WEB 服务请注明或链接本站：<a href="http://www.webxml.com.cn/" target="_blank">http://www.webxml.com.cn/</a>
 * 感谢大家的支持！<br />&nbsp;
 */
    public java.lang.String getMobileCodeWSSoapAddress();

    public cn.edu.nuc.ssm.webService.mobil.MobileCodeWSSoap_PortType getMobileCodeWSSoap() throws javax.xml.rpc.ServiceException;

    public cn.edu.nuc.ssm.webService.mobil.MobileCodeWSSoap_PortType getMobileCodeWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getMobileCodeWSSoap12Address();

    public cn.edu.nuc.ssm.webService.mobil.MobileCodeWSSoap_PortType getMobileCodeWSSoap12() throws javax.xml.rpc.ServiceException;

    public cn.edu.nuc.ssm.webService.mobil.MobileCodeWSSoap_PortType getMobileCodeWSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
