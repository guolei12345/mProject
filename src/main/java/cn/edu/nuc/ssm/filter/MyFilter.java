package cn.edu.nuc.ssm.filter;

import cn.edu.nuc.ssm.logger.BaseLog;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器
 */
public class MyFilter extends BaseLog implements Filter{
    Map<String,Boolean> filterMap = new HashMap<>();
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("MyFilter：init");
        filterMap.put("/user/updatePass",true);
        filterMap.put("/user/regist",true);
        filterMap.put("/user/login",true);
        filterMap.put("/user/getVerify",true);
        filterMap.put("/user/sendCheck",true);
        filterMap.put("/",true);
        filterMap.put(".",true);
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
        String url = req.getRequestURI();
        logger.info("请求地址："+url);
        //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面就不去检查.
        String requestURI = url.replace("mproject/","");
        if(filterMap.get(requestURI)!= null && !filterMap.get(requestURI))
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
