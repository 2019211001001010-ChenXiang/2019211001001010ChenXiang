<%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/4/25 0025
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<!--need form -->
<%
    //get user from session
    User u=(User) session.getAttribute("user");
%>

<form method="post" action="updateUser"><!-- within doPost() in servlet-->
    <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <input type="text" name="username" placeholder="username" value="<%=u.getUsername()%>" style="width: 200px;height: 25px;margin-top: 2px"><br/>
    <input type="password" name="password" placeholder="password" value="<%=u.getPassword()%>" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    <input type="text" name="email" placeholder="email" value="<%=u.getEmail() %>" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    Gender <input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":" "%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked":" "%>>Female<br/>
    <input type="text" name="birthdate" placeholder="Date of Birth(yyyy-mm-dd)" value="<%=u.getBirthdate()%>" style="width: 200px;height: 25px;margin-top: 5px;margin-bottom: 5px"><br/>
    <input type="submit" value="Save Changes" style="background-color: cornflowerblue;color: white;width: 100px;height: 25px;font-size: 15px">
    <input type="checkbox" name="check"value="password"font size="10px">remember passwords<br/>
</form>
<%@include file="footer.jsp"%>