package com.chenxiang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/*@WebServlet(
        urlPatterns = {"/register"}
)*/
//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    Connection con=null; //class variable


    @Override
    public void init() throws ServletException{
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change

        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here
        //get parameter from request.
        PrintWriter writer = response.getWriter();
        String sql="insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?) ";
        int id=Integer.valueOf(request.getParameter("ID"));
        String username =request.getParameter("Username");//name of input type -<input type="text" name = "username"/><br/>
        String password =request.getParameter("password");
        String email =request.getParameter("Email");
        String gender =request.getParameter("sex");
        String birthdate =request.getParameter("birthday");
        PreparedStatement pstmt= null; //调用javaSQL包的PreparedStatement来存储待运行的SQL语句
        try {
            System.out.println("id:"+id);
            System.out.println("usrname:"+username);
            System.out.println("password:"+password);
            System.out.println("email:"+email);
            System.out.println("gender:"+gender);
            System.out.println("birthday:"+birthdate);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,username);
            pstmt.setString(3,password);
            pstmt.setString(4,email);
            pstmt.setString(5,gender);
            pstmt.setString(6,birthdate);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String sql_1="select * from usertable";
        writer.print("<html>");
        writer.print("<table border='1'>");
        writer.print("<tr>");
        writer.print("<td>ID</td>");
        writer.print("<td>UserName</td>");
        writer.print("<td>Password</td>");
        writer.print("<td>Email</td>");
        writer.print("<td>Sex</td>");
        writer.print("<td>BirthDay</td>");
        writer.print("</tr>");
        try {
            ResultSet rs=con.createStatement().executeQuery(sql_1);
            while(rs.next()){
                //get from rs - print - write into response
                writer.print("<tr>");
                writer.print("<td>"+rs.getString(1));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(2));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(3));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(4));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(5));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(6));
                writer.print("</td>");
                writer.print("</tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        writer.print("</table>");
        writer.print("</html>");

        //print - write into response
    }
    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close(); //when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}