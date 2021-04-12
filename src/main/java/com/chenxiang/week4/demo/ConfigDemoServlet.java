package com.chenxiang.week4.demo;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name=config.getInitParameter("name"); //<param-name>name</param-name>
        String studentid=config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println( "name:"+name);
        writer.println( "studentid:"+studentid);
        //next we need to tell about this servlet to tomcat - how ? - web.xml
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}