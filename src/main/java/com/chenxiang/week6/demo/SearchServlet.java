package com.chenxiang.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        String txt = request.getParameter("txt");
        if (txt=="") {
            response.sendRedirect("index.jsp");
        } else {
            if (search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
                System.out.print("i am in baidu");
            } else if (search.equals("bing")) {
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
                System.out.print("i am in bing");
            } else if (search.equals("google")) {
                response.sendRedirect("https://www.google.com/search?q="+txt);
                System.out.print("i am in google");
            }
        }
      }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
