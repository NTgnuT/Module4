package com.example.productdiscountcaculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "discount", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Double discount = Double.valueOf(req.getParameter("discount"));

        Double disAmount = price * discount * 0.01;
        Double disPrice = price - disAmount;

        req.setAttribute("description", description);
        req.setAttribute("price", price);
        req.setAttribute("discount", discount);
        req.setAttribute("disAmount", disAmount);
        req.setAttribute("disPrice", disPrice);

        req.getRequestDispatcher("hien-thi.jsp").forward(req,resp);
    }
}
