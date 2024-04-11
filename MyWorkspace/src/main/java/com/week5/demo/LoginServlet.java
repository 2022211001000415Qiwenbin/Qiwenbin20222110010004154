package com.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
//        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try {
//            Class.forName(driver);

        con=(Connection) getServletContext().getAttribute("con");
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
//        String str = "select id,username,password,email,gender,birthdate * from usertable where username= 'Liuxiang' and password= '2022211001000413'";
        String str = "SELECT id, username, password, email, gender, birthdate FROM usertable WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            ResultSet rus=con.createStatement().executeQuery(str);
            PrintWriter writer=response.getWriter();
            if (rus.next()){
//            writer.println("LOGIN SUCCESS !!!");
//            writer.println("WELCOME,");}
                request.setAttribute("username",rus.getString("username"));
                request.setAttribute("password",rus.getString("password"));
                request.setAttribute("email",rus.getString("email"));
                request.setAttribute("gender",rus.getString("gender"));
                request.setAttribute("birthdate",rus.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
            else{
//                writer.println("LOGIN ERROR!!!");
                request.setAttribute("message","username or password error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
