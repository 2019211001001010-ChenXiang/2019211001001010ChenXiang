<%@include file="header.jsp"%>
<h2>Welcome to My Online Shop Home Page.</h2> <br>
<form method="get" target='_blank' action="search">
    <!-- <url-pattern> search </url-pattern> -->
    <input type="text" name="txt" size=index.jsp30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
        </select>
            <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC -week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">login-week5</a>
<%@include file="footer.jsp"%>