<%--
  Created by IntelliJ IDEA.
  User: 陈翔
  Date: 2021/6/15 0015
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String firstVal = "";
    String secondVal = "";
    String name = "";
    String result = "";
    String length = "";
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cFirstVal")){
                firstVal = cookie.getValue();
            }
            if (cookie.getName().equals("cSecondVal")){
                secondVal = cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                result = cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                name = cookie.getValue();
            }
            if (cookie.getName().equals("cLength")){
                length = cookie.getValue();
            }
        }
    }
%>
<form action="${pageContext.request.contextPath}/CalServlet" method="post">
        <span>
            First Val:&nbsp&nbsp&nbsp&nbsp<input type="text" name="firstVal" id="firstVal" value="<%=firstVal%>"/>
            Enter a Name:<input type="text" name="name" id="enterName" value="<%=name%>"/>
        </span><br/>
    <span>
            Second Val:<input type="text" name="secondVal" id="secondVal" value="<%=secondVal%>"/>
            Length:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="length" value="<%=length%>"/>
        </span><br/>
    <span>
            Result:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="result" value="<%=result%>"/>
        </span><br/>
    <input type="hidden" class="action" name="action"/>
    <button type="submit" class="but" name="add" onclick="isNan()">Add</button>
    <button type="submit" class="but" name="subtract" onclick="isNan()">Subtract</button>
    <button type="submit" class="but" name="multiply" onclick="isNan()">Multiply</button>
    <button type="submit" class="but" name="divide">Divide</button>
    <button type="submit" class="but" name="computeLength" onclick="isString()">Compute Length</button>
    <button type="button" id="myForm" onclick="reset()">Reset</button>
</form>
<script type="text/javascript">
    let firstVal = document.getElementById("firstVal");
    let enterName = document.getElementById("enterName");
    let secondVal = document.getElementById("secondVal");
    $(".but").click(function () {
        let name = $(this).attr("name");
        $(".action").val(name);
    });
    function isNan() {
        if (isNaN(firstVal.value)){
            alert("First Value is not a Number");
        }else if (isNaN(secondVal.value)){
            alert("Second Value is not a Number");
        }
        return true;
    }
    function isString() {
        if (!isNaN(enterName.value)){
            alert("Name is not valid")
        }
        return true;
    }
    function reset() {
        document.getElementById("myForm").onreset();
    }
</script>
</body>
</html>