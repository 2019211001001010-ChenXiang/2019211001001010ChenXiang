<%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/4/2 0002
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="login"><!-- within doPost() in servlet-->
    <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    <h1>Login</h1>
    UserName:<input type="text" name="Username"  style="width: 200px;height: 25px;margin-top: 2px"><br/>
    Password:<input type="passowrd" name="Password"  style="width: 200px;height: 25px;margin-top: 2px"><br/>
    <input type="submit" name="password" value="login" style="background-color: gainsboro;color: black;width: 60px;height: 25px;font-size: 15px"><br/>

<%@include file="footer.jsp"%>
