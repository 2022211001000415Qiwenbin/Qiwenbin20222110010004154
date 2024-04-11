<%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2024/4/4
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%
    if(!(request.getAttribute("message")==null)){

        out.println(request.getAttribute("message"));
    }
%>
<body>
<form action="login" method="post">
    username :<input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
<%@include file="footer.jsp"%>

