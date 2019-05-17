package com.yuxin.platform.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "LoginFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "loginStrings", value = "/login.html;/userlogin;/fonts/;/qyjbxx/insertQyjbxxBySeal;/qyry/insertCyryBySeal"),
        @WebInitParam(name = "StaticResource", value = ".js;.css;.png;.jpg;.gif;.ico;"),
        @WebInitParam(name = "redirectPath", value = "/login.html"),
        @WebInitParam(name = "interfacePath", value = "/sub/lock/order/add")}
        )
public class LoginFilter implements Filter {

    public FilterConfig filterConfig;


    @Override
    public void init(FilterConfig filterConfig) {
        // TODO Auto-generated method stub
        //System.out.println("过滤器初始化");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String loginStrings = filterConfig.getInitParameter("loginStrings");
        String StaticResource = filterConfig.getInitParameter("StaticResource");
        String redirectPath = filterConfig.getInitParameter("redirectPath");
        String  interfacePath= filterConfig.getInitParameter("interfacePath");
        String path = req.getRequestURI();
        HttpSession session = req.getSession();
        String[] loginList = loginStrings.split(";");
        String[] StaticResourceList = StaticResource.split(";");
        System.out.println("请求地址" + path);
        if (isContains(path, StaticResourceList) || path.contains(interfacePath)) {
            System.out.println("静态资源放行");
            chain.doFilter(request, response);
            return;
        }
        if (isContains(path, loginList)) {
            System.out.println("登录页放行");
            chain.doFilter(request, response);
            return;
        }

        Object user = session.getAttribute("user");
        System.out.println(session.getId());
        if (user == null) {
            if (req.getHeader("x-requested-with") != null
                    && "XMLHttpRequest".equalsIgnoreCase(req.getHeader("x-requested-with"))) {
                System.out.println("ajax请求，到前台去跳转");
                res.setHeader("sessionstatus", "timeout");
                return;
            }
            System.out.println("没有登录，跳转到登录页");
            res.sendRedirect(request.getServletContext().getContextPath() + redirectPath);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        // System.out.println("过滤器销毁");
    }

    public static boolean isContains(String container, String[] regx) {
        boolean result = false;
        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }

}
