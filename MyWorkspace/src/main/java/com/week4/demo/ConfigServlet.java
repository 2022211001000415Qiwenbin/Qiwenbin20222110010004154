package com.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ConfigServlet",
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="myname",value = "Qiwenbin"),
                @WebInitParam(name="id",value = "2022211001000415")
        }
)
public class ConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = getServletConfig().getInitParameter("myname");
        String studentId = getServletConfig().getInitParameter("id");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Name: " + name + "<br>");
        out.println("Student ID: " + studentId + "<br><br><br>");
    }
}