package com.chenxiang.controller;

import com.chenxiang.dao.UserDao;
import com.chenxiang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")//url
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code
        //TODO 1 :forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
        //TODO 2 :create one jsp page - update User
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update user info- can update password,email,gender,birthDate
        //TODO 1:get all (6) request parameters
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        //TODO 2:create an object of User Model
        User user=new User();
        //TODO 3:set all 6 request parameters values into User model - setXXX()
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthdate(ft.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //TODO 4:create an object of UserDao
        UserDao userDao=new UserDao();
        //TODO 5:call updateUser() in UserDao
        try{
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        //TODO 6:forward to WEB-INF/views/userInfo.jsp

    }
}
