package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // xử lý method POST
        // Lấy dữ liệu từ request gửi lên từ form
        // System.out.println(req.getParameter("email"));
        // System.out.println(req.getParameter("userName"));
        String userName = req.getParameter("userName");
        req.setAttribute("userName", userName);
        // chuyển sang trang cam-on.jsp và hiển thị tên của thằng vừa đăng ký
        req.getRequestDispatcher("cam-on.jsp").forward(req,resp);
    }
}
