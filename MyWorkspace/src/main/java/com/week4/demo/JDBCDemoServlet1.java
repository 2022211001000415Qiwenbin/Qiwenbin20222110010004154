package com.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "JDBCDemoServlet", value = "/JDBCDemoServlet")
public class JDBCDemoServlet1 extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost;databaseName=userdb";
       // String username="sa";
       // String password="123456";


        ServletConfig config=getServletConfig();
      String driver= config.getInitParameter("driver");
        String url= config.getInitParameter("url");
        String username= config.getInitParameter("username");
        String password= config.getInitParameter("password");

        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doget()");
        String sql="select*from usertable";
        try {
            ResultSet rs= con.createStatement().executeQuery(sql);
            while(rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
