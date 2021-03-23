package com.chenxiang.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//automatic -new -->servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here-<from method=post>
        //get parameter from request
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");//<input type="password" name="password"/>
        String email = request.getParameter("email");//<input type="text" name="Email"/>
        String gender = request.getParameter("gender");//<input type="radio" name="gender"/>
        String birthdate = request.getParameter("birthdate");

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>gender :"+gender);
        writer.println("<br>birth Date"+birthdate);
        writer.close();


    }
}
