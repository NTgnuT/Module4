package com.example.controller;

import com.example.modal.entity.Category;
import com.example.modal.service.CategoryService;
import com.example.modal.service.CategoryServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/danh-muc")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showList(request,response);
        }

        switch (action) {
            case "add":
                response.sendRedirect("views/add-category.jsp");
                break;
            case "edit":
                // Lấy về id trên URL

                break;
            case "delete":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cấu hình chữ
        request.setCharacterEncoding("UTF-8");


        String action = request.getParameter("action");
        if (action == null) {
            // Lấy dữ liệu
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryStatus(Boolean.parseBoolean(request.getParameter("categoryStatus")));

            if (categoryService.save(category)) {
                showList(request,response);
            }
            response.sendRedirect("views/add-category.jsp?err");
        }
    }

    public void showList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/category.jsp").forward(request,response);
    }
}