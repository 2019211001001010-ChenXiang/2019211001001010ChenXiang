<%@ page import="com.chenxiang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/4/12 0012
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--<%
    //read cookies
    Cookie[] allCookies=request.getCookies();//all cookies
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>--%>
<%
    //get user from session
    User u=(User) session.getAttribute("user");
%>


<table>
    <tr><td>id:</td><td><%=u.getId()%></td></tr>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%=u.getBirthdate()%></td></tr>
    <a href="updateUser">Update User</a>
</table>


<%@include file="footer.jsp"%>
