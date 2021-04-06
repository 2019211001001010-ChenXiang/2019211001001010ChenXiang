package com.chenxiang.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/login"},
        initParams = {
                @WebInitParam(name="driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url", value = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb"),
                @WebInitParam(name="username", value = "sa"),
                @WebInitParam(name="password", value = "123456")
        })

public class LoginServlet extends HttpServlet {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    @Override
    public void init() throws ServletException{
        String driver=getServletConfig().getInitParameter("driver");
        String url=getServletConfig().getInitParameter("url");
        String name=getServletConfig().getInitParameter("username");
        String password=getServletConfig().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,name,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //TODO 1: get context param -driver,url,username,password
        //TODO 2:get jdbc connection
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        // TODO 4:  VALIDATE USER - SELECT * FROM USERTABLE WHERE USERNAME= 'XXX'
        // AND PASSWORD='YYY'
        // TODO 5:CHECK IF(USER IS VAL ID){

        // OUT.PRINTLN("LOGIN SUCCESS ! ! !") ;
        // OUT.PRINT ("WELCOME, USERNAME");
        // }ELSE{
        //  OUT.PRINT(LOGIN ERROR!!!);
        //}
        String username=request.getParameter("Username");
        String password=request.getParameter("Password");
        System.out.println("hello world");
        PrintWriter writer = response.getWriter();
        try {
            ps=con.prepareStatement(("SELECT* FROM usertable where username=? and password=?"));
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if (rs.next()){ //if exist
                System.out.println(rs.getString(1)+ " "+ rs.getString(2));
                writer.println("<html>\n" + "<head>\n" + "</head>\n" + "\t<p style=\"font-size:24px;\">" +
                        "<b>Login Success!!!<br>Welcome,chengxiang</b></p>"+ "<body>\n" + "</body>\n" + "</html>\n" );
            }
            else
                writer.println("Username or Password Error!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
