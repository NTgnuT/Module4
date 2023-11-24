package com.example.listcustomersjsp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/helloServlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyễn A", "20/01/2000", "Hà Nội", "https://hinhgoc.net/upload/img/imagestock-0217.jpg?quality=100&width=1200&height=1200"));
        customers.add(new Customer("Nguyễn A", "20/01/2000", "Hà Nội", "https://hinhgoc.net/upload/img/imagestock-0217.jpg?quality=100&width=1200&height=1200"));
        customers.add(new Customer("Nguyễn A", "20/01/2000", "Hà Nội", "https://hinhgoc.net/upload/img/imagestock-0217.jpg?quality=100&width=1200&height=1200"));
        customers.add(new Customer("Nguyễn A", "20/01/2000", "Hà Nội", "https://hinhgoc.net/upload/img/imagestock-0217.jpg?quality=100&width=1200&height=1200"));
        customers.add(new Customer("Nguyễn A", "20/01/2000", "Hà Nội", "https://hinhgoc.net/upload/img/imagestock-0217.jpg?quality=100&width=1200&height=1200"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("view.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}