package com.example.controller;

import com.example.model.Customer;
import com.example.service.customer.CustomerServiceIMPL;
import com.example.service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Customer", value = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
//            showListCustomer(req,resp);
            action = "";
        }

        switch (action) {
            case "create":
                req.getRequestDispatcher("views/customer/create.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Customer editCustomer = customerService.findById(id);
                req.setAttribute("editCustomer", editCustomer);
                req.getRequestDispatcher("views/customer/edit.jsp");
                break;
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                customerService.deleteById(idDelete);
                showListCustomer(req, resp);
                break;
            case "search":
                String searchName = req.getParameter("inputSearch");
                List<Customer> searchCustomers = customerService.findByName(searchName);
                req.setAttribute("customerList", searchCustomers);
                req.setAttribute("searchName", searchName);
                req.getRequestDispatcher("views/customer/list.jsp");
                showListCustomer(req, resp);
                break;
            default:
                showListCustomer(req, resp);
                break;
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set lại ký tự
        request.setCharacterEncoding("UTF-8");

        int cusId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                Customer newCustomer = new Customer(customerService.getNewId(), name, email, address);
                customerService.save(newCustomer);
                showListCustomer(request, response);
                break;
            case "edit":
                Customer editCustomer = new Customer(cusId, name, email, address);
                customerService.save(editCustomer);
                showListCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
        }
    }

    public void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customer", customerList);
        request.getRequestDispatcher("views/customer/list.jsp").forward(request, response);
    }
}
