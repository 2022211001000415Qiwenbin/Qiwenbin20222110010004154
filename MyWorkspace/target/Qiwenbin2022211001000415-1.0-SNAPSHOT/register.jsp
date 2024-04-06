<%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2024/3/18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
    <form  action="register" method="post" >
       username :<input type="text" name="username"><br>

       password: <input type="password" name="password"><br>
       email :<input type="text" name="email"><br>

        Gender: <input type="radio" name="gender" value="male"> Male <input type="radio" name="gender" value="female">Female<br>
        Date of Birth: <input type="text name=" name="birthdate"><br>
        <input type="submit" value="Register">
    </form>
<%@include file="footer.jsp"%>
