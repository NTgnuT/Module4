package com.example.caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "caculatorServlet", value = "/caculator-servlet")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //lay du lieu ve
            double firstNumber = Double.parseDouble(req.getParameter("first"));
            double secondNumber = Double.parseDouble(req.getParameter("second"));
            Character operator = req.getParameter("operator").charAt(0);

            //tinh toan
            Caculator calculator = new Caculator();
            double result = calculator.caculate(firstNumber, secondNumber, operator);

            //set de hien thi du lieu tren jsp
            req.setAttribute("firstNumber", firstNumber);
            req.setAttribute("secondNumber", secondNumber);
            req.setAttribute("operator", operator);
            req.setAttribute("result", result);

            //chuyen sang trang jsp va hien thi du lieu
            req.getRequestDispatcher("ket-qua.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Phep tinh khong hop le");
        }
    }
}
