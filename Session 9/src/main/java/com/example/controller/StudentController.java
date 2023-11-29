package com.example.controller;

import com.example.modal.entity.Student;
import com.example.modal.service.Student.StudentService;
import com.example.modal.service.Student.StudentServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private final StudentService studentService = new StudentServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            showList(request, response);
        }

        switch (action) {
            case "add":
                response.sendRedirect("views/add-student.jsp");
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                Student student = studentService.findById(idEdit);
                request.setAttribute("stu", student);
                request.getRequestDispatcher("views/edit-student.jsp").forward(request, response);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                studentService.delete(idDelete);
                showList(request, response);
                break;
            case "search":
                String nameSearch = request.getParameter("name");
                request.setAttribute("nameSearch", nameSearch);
                List<Student> students = studentService.findByName(nameSearch);
                request.setAttribute("list", students);
                request.getRequestDispatcher("views/student.jsp").forward(request, response);
                break;
            case "sort":
                List<Student> studentList = studentService.sortById();
                request.setAttribute("list", studentList);
                request.getRequestDispatcher("views/student.jsp").forward(request, response);
                break;
            default:
                showList(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cấu hình chữ
        request.setCharacterEncoding("UTF-8");

        Student student = new Student();
        student.setStudentName(request.getParameter("studentName"));
        student.setEmail(request.getParameter("email"));
        student.setBirthday(Date.valueOf(request.getParameter("birthday")));
        student.setAddress(request.getParameter("address"));

        if (request.getParameter("id") != null) {
            student.setStudentId(Integer.parseInt(request.getParameter("id")));
        }
//        System.out.println(student);
        if (studentService.save(student)) {
            System.out.println("ok");
            showList(request, response);
        }
        response.sendRedirect("views/add-student.jsp?err");

    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }

}