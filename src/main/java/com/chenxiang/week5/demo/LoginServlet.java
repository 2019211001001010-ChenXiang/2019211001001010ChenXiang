package com.chenxiang.week5.demo;

import com.chenxiang.dao.UserDao;
import com.chenxiang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    @Override
    public void init() throws ServletException{
        super.init();
        /*ServletContext Context=getServletContext();
        String driver=Context.getInitParameter("driver");
        String url=Context.getInitParameter("url");
        String username=Context.getInitParameter("username");
        String password=Context.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        //TODO 1: get context param -driver,url,username,password
        //TODO 2: get jdbc connection
        //only one one
        con= (Connection) getServletContext().getAttribute("con");
        //check the video live demo
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
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
            UserDao userDao=new UserDao();
            User user = userDao.findByUsernamePassword(con,username,password);//use for login
            if(user!=null){//valid
                //week 8 code
                /*Cookie c=new Cookie("sessionid",""+user.getId());// sessionid = user-id
                // step 2:set age of cookie
                c.setMaxAge(10*60);//in sec-10 min- 7 days - 7*24*60*60
                // step 3:add cookie into response
                response.addCookie(c);*/
                //create cookie
                String rememberMe=request.getParameter("rememberMe");;//1=checked, null if checked
                if(rememberMe!=null && rememberMe.equals("1")){
                  Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                  Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                  Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                  //set age of cookies
                    usernameCookie.setMaxAge(5);//5 sec for test - set 15 days=60*60*24*15
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    //add cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session=request.getSession();//create a new session
                //check session id
                System.out.println("session id-->"+session.getId());//session id
                //set time for session
                session.setMaxInactiveInterval(10);//for 5 10 section if request not come in - tomcat kill session

                //set user model into request
                //week 8 change request to session - so we can get session attribute in many isp pages
                session.setAttribute("user",user);//get user info in session
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else{//invalid
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*try {
            ps=con.prepareStatement(("SELECT* FROM usertable where username=? and password=?"));
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if (rs.next()){ //if exist
                //week 5 code
                System.out.println(rs.getString(1)+ " "+ rs.getString(2));
                //writer.println("Login Success!!!" );
                //writer.println("Welcome,"+username);
                //get from rs and set into request attribute
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                //forward to userinfo.jsp
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);

            }
            else {
                //writer.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}
