/**
 * ValidateCodeWebServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.nuc.ssm.webService.validateCode;

public interface ValidateCodeWebServiceSoap_PortType extends java.rmi.Remote {

    /**
     * <br /><h3>直接获得验证码图片（小）</h3><p>输入参数：字符串，英文字母、符号或数字（为避免混淆请去除如：I
     * 和 1 等，并转成大写），最多支持8个字符，如需要支持更多字符请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
     * target="_blank">联系我们</a>，默认随机输出4个字符图片； 返回数据：验证码图片。</p><br />
     */
    public void smallValidateImage(java.lang.String byString) throws java.rmi.RemoteException;

    /**
     * <br /><h3>获得验证码图片字节数组（小）</h3><p>输入参数：字符串，英文字母、符号或数字（为避免混淆请去除如：I
     * 和 1 等，并转成大写），最多支持8个字符，如需要支持更多字符请<a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx"
     * target="_blank">联系我们</a>，默认随机输出4个字符图片字节流； 返回数据：验证码图片字节流。</p><br />
     */
    public byte[] smallValidateByte(java.lang.String byString) throws java.rmi.RemoteException;

    /**
     * <br /><h3>直接获得验证码图片（为英文/数字优化）</h3><p>输入参数：字符串，英文字母、符号或数字，最多支持8个字符，如需要支持更多字符请<a
     * href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，默认随机输出4个字符图片；
     * 返回数据：验证码图片。</p><br />
     */
    public void enValidateImage(java.lang.String byString) throws java.rmi.RemoteException;

    /**
     * <br /><h3>获得验证码图片字节数组（为英文/数字优化）</h3><p>输入参数：字符串，英文字母、符号或数字，最多支持8个字符，如需要支持更多字符请<a
     * href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，默认随机输出4个字符图片字节流；
     * 返回数据：验证码图片字节流。</p><br />
     */
    public byte[] enValidateByte(java.lang.String byString) throws java.rmi.RemoteException;

    /**
     * <br /><h3>直接获得验证码图片（为中文字优化）</h3><p>输入参数：字符串，中文字，最多支持8个字，如需要支持更多字符请<a
     * href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，默认随机输出4个中文简体字图片；
     * 返回数据：验证码图片。</p><br />
     */
    public void cnValidateImage(java.lang.String byString) throws java.rmi.RemoteException;

    /**
     * <br /><h3>获得验证码图片字节数组（为中文字优化）</h3><p>输入参数：字符串，中文字，最多支持8个字，如需要支持更多字符请<a
     * href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，默认随机输出4个中文简体字图片字节流；
     * 返回数据：验证码图片字节流。<br /><strong>字节流到图片可以参考以下方法</strong>（.NET vb）：<br />HttpContext.Current.Response.Cache.SetCacheability(System.Web.HttpCacheability.NoCache)
     * '不缓存<br />HttpContext.Current.Response.ClearContent()<br />HttpContext.Current.Response.ContentType
     * = "image/Png" '本服务输出Png类型<br />HttpContext.Current.Response.BinaryWrite(Ary)
     * 'Ary 图片字节数组<br />HttpContext.Current.Response.End()</p><br />
     */
    public byte[] cnValidateByte(java.lang.String byString) throws java.rmi.RemoteException;
}
