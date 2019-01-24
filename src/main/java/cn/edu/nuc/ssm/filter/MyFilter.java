package cn.edu.nuc.ssm.filter;

import cn.edu.nuc.ssm.logger.BaseLog;

import javax.servlet.*;
import java.io.IOException;

/**
 * 拦截器
 */
public class MyFilter extends BaseLog implements Filter{
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("MyFilter：init");
    }

    /**
     * 执行拦截
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyFilter：doFilter");

    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        logger.info("MyFilter：destroy");
    }
}
