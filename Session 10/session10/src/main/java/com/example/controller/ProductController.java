package com.example.controller;

import com.example.modal.entity.Category;
import com.example.modal.entity.Product;
import com.example.modal.service.category.CategoryService;
import com.example.modal.service.category.CategoryServiceIMPL;
import com.example.modal.service.product.ProductService;
import com.example.modal.service.product.ProductServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductServiceIMPL();
    private final CategoryService categoryService = new CategoryServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            showList(request, response);
        }

        switch (action) {
            case "add":
                List<Category> categories = categoryService.findAll();
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("views/add-product.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Product product = new Product();
        product.setProductName(request.getParameter("productName"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setCategory(categoryService.findById(Integer.valueOf(request.getParameter("categoryId"))));

        productService.save(product);
        showList(request, response);
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("listProduct", products);
        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }
}