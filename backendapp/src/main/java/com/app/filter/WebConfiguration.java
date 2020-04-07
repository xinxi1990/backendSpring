//package com.app.filter;
//
//
//import org.apache.catalina.filters.RemoteIpFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class WebConfiguration {
//
//
//    @Bean
//    public RemoteIpFilter remoteIpFilter() {
//        return new RemoteIpFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new PiceaFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("PiceaFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//
//    @Order(1)
//    @WebFilter(filterName = "piceaFilter", urlPatterns = "/query" , initParams = {
//            @WebInitParam(name = "URL", value = "http://localhost:8080")})
//    public class PiceaFilter implements Filter {
//
//        private String url;
//
//        /**
//         * 可以初始化Filter在web.xml里面配置的初始化参数
//         * filter对象只会创建一次，init方法也只会执行一次。
//         * @param
//         * @throws ServletException
//         */
//
//
//        @Override
//        public void destroy() {
//            // TODO Auto-generated method stub
//            System.out.println("我是过滤器的被销毁时调用的方法！，活不下去了................" );
//        }
//
//        @Override
//        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
//                throws IOException, ServletException {
//            // TODO Auto-generated method stub
////            System.out.println("doFilter ==>");
////            HttpServletRequest request = (HttpServletRequest) srequest;
////            System.out.println("this is MyFilter,url :"+request.getRequestURI());
////            filterChain.doFilter(srequest, sresponse);
//
//
//            System.out.println("我是过滤器的执行方法，客户端向Servlet发送的请求被我拦截到了");
//            HttpServletRequest servletRequest = (HttpServletRequest) srequest;
//            HttpServletResponse servletResponse = (HttpServletResponse) sresponse;
//            filterChain.doFilter(servletRequest, servletResponse);
//            System.out.println("我是过滤器的执行方法，Servlet向客户端发送的响应被我拦截到了");
//
//        }
//
//        @Override
//        public void init(FilterConfig filterConfig) throws ServletException {
//            // TODO Auto-generated method stub
//            this.url = filterConfig.getInitParameter("URL");
//            System.out.println("我是过滤器的初始化方法！URL=" + this.url +  "，生活开始.....");
//        }
//    }
//
//
//}
