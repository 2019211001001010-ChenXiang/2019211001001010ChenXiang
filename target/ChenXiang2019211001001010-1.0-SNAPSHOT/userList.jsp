<%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/4/10 0010
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1> User List</h1>
<table border="1">
    <tr>
        <td>ID</td><td>UserName</td><td>Password</td><td>Email</td>
        <td>Sex</td><td>BirthDay</td>
    </tr>
    <%
        //get rs from request attriute
        ResultSet rs= (ResultSet) request.getAttribute("rsname");//name of attribute -
        if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            //get from rs - print - write into response
            out.println("<tr>");
            out.println("<td>" + rs.getString(1));
            out.println("</td>");
            out.println("<td>" + rs.getString(2));
            out.println("</td>");
            out.println("<td>" + rs.getString(3));
            out.println("</td>");
            out.println("<td>" + rs.getString(4));
            out.println("</td>");
            out.println("<td>" + rs.getString(5));
            out.println("</td>");
            out.println("<td>" + rs.getString(6));
            out.println("</td>");
            out.println("</tr>");
        }
    }
    %>
    <%--we will get data in next demo - 6.LiveDemo #3--%>
</table>
<%@include file="footer.jsp"%>
