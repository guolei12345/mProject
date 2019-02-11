package cn.edu.nuc.ssm.filter;

import cn.edu.nuc.ssm.entity.User;
import cn.edu.nuc.ssm.logger.BaseLog;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        request.setCharacterEncoding("utf-8");
        HttpServletRequest req =(HttpServletRequest)request;
        HttpServletResponse res  =(HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        String url = ((HttpServletRequest) request).getContextPath();
        //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面就不去检查.
        if(!"/user/updatePass".equals(requestURI) &&!"/user/regist".equals(requestURI) &&!"/user/login".equals(requestURI) && !"/".equals(requestURI)&&!requestURI.contains(".")&&!"/user/getVerify".equals(requestURI))
        {
            //取得session. 如果没有session则自动会创建一个, 我们用false表示没有取得到session则设置为session为空.
            HttpSession session = req.getSession(false);
            //如果session中没有任何东西.
            if(session == null ||session.getAttribute("user")==null)
            {
                res.sendRedirect(req.getContextPath() + "/user/login");
                //返回
                return;
            }

        }
        chain.doFilter(request,response);
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        logger.info("MyFilter：destroy");
    }
}
