package com.chenxiang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoggerFilter-->doFilter()- before servlet-(request come here)");//when called?
        //request blocked after this filter
        chain.doFilter(request, response);// call next filter - if no next filter - then go to servlet
        //response after
        System.out.println("i am in LoggerFilter-->doFilter()- after servlet-(response come here)");//when called?
    }
}
