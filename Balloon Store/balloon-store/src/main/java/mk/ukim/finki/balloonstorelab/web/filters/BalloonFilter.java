package mk.ukim.finki.balloonstorelab.web.filters;//package mk.ukim.finki.wpballoonstore.web.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class BalloonFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse)  servletResponse;
//
//        String color = (String) request.getSession().getAttribute("color");
//        String path = request.getServletPath();
//
//        if (color != null || "".equals(path) || "/balloons".equals(path)){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }else {
//         response.sendRedirect("");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
