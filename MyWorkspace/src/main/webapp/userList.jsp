<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2024/4/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=1>

    <tr>
        <td>id</td><td>password</td><td>email</td><td>gender</td><td>birthdate</td>
    </tr>
    <%
        ResultSet rs =(ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        No data!!
    </tr>
    <%}else{
        while (rs.next()) {
            out.println("</tr>");
            out.println("<t`d>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");

            out.println("</tr>");
        }
    }
    %>
</table>

<%@include file="footer.jsp"%>