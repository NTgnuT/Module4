package com.example.controller;

import com.example.modal.entity.Category;
import com.example.modal.service.category.CategoryService;
import com.example.modal.service.category.CategoryServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryCotroller", value = "/category")
public class CategoryCotroller extends HttpServlet {
    private final CategoryService categoryService = new CategoryServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showList(request, response);
        }
        switch (action) {
            case "add":
                response.sendRedirect("views/add-category.jsp");
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        Category category = new Category();
        category.setCategoryName(request.getParameter("categoryName"));
        category.setStatus(Boolean.parseBoolean(request.getParameter("status")));

        categoryService.save(category);
        showList(request, response);
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/category.jsp").forward(request, response);
    }
}