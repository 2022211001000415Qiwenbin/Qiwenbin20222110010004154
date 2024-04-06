package com.Qiwenbin.week3.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    Connection con=null;


        @Override
        public void init() {
            String driver = getServletContext().getInitParameter("driver");
            String url = getServletContext().getInitParameter("url");
            String username = getServletContext().getInitParameter("username");
            String password = getServletContext().getInitParameter("password");

            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            String id1 = "1";
            String username1 = "Qiwenbin";
            String password1 = "2022211001000415";
            String email1 = "1111@qq.com";
            String gender1 = "male";
            String birthdate1 = "2003-02-12";

            try {
                PreparedStatement stmt = con.prepareStatement("insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)");
                stmt.setString(1, id1);
                stmt.setString(2, username1);
                stmt.setString(3, password1);
                stmt.setString(4, email1);
                stmt.setString(5, gender1);
                stmt.setString(6, birthdate1);
                //set other parameters
                stmt.executeUpdate();
                con.commit();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) {

            try {
                // Your code to retrieve data from the database
                String str = "select * from usertable";
                ResultSet rs = con.createStatement().executeQuery(str);

                PrintWriter writer = response.getWriter();
                writer.println("<html><head><meta charset=\"UTF-8\"><title>User Information</title></head><body>");
                writer.println("<table border='1'>");
                writer.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
                while (rs.next()) {
                    String id = rs.getString("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String gender = rs.getString("gender");
                    String birthdate = rs.getString("birthdate");

                    writer.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td>" + email + "</td><td>" + gender + "</td><td>" + birthdate + "</td></tr>");
                }
                writer.println("</table>");
                writer.println("</body></html>");

            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void destroy() {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }