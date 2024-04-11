package com.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "SearchServlet", value = "/Search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        if (txt == null || txt.isEmpty()) {
            // 如果txt为空，重定向到主页
            response.sendRedirect("/index.jsp");
        } else {
            if ("baidu".equals(search)) {
                // 重定向到百度
                response.sendRedirect("https://www.baidu.com/s?wd=" + URLEncoder.encode(txt, "UTF-8"));
            } else if ("bing".equals(search)) {
                // 重定向到必应
                response.sendRedirect("https://cn.bing.com/search?q=" + URLEncoder.encode(txt, "UTF-8"));
            } else if ("google".equals(search)) {
                // 重定向到谷歌
                response.sendRedirect("https://www.google.com/search?q=" + URLEncoder.encode(txt, "UTF-8"));
            }
        }
    }
}