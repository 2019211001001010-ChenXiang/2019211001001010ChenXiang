<%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/4/2 0002
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <!-- within doPost() in servlet-->
    <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    <h1>Login</h1>
    <%
        if(!(request.getAttribute("message")==null)){
            //error
            out.println(request.getAttribute("message"));
        }
    %>
<%
    //read cookies

    Cookie[] allCookies=request.getCookies();//give all cookies
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
           //get one by one
            if(c.getName().equals("cUsername")){
                //get value of this cookies
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                //get value of this cookies
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                //get value of this cookies
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    UserName:<input type="text" name="Username" value="<%=username%>"><br/>
    Password:<input type="passowrd" name="Password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" name="password" value="login" style="background-color: gainsboro;color: black;width: 60px;height: 25px;font-size: 15px"><br/>
    </form>
<%@include file="footer.jsp"%>
