package com.example.ly_thuyet.controler;

import com.example.ly_thuyet.modal.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private final List<Student> students = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        students.add(new Student("T.T001", "Nguyễn A", "Hà Nội", 25, "JAVA", true));
        students.add(new Student("T.T005", "Nguyễn B", "Hà Nam", 24, "PHP", true));
        students.add(new Student("T.T010", "Nguyễn C", "Hà Tĩnh", 27, "JS", true));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("action"));
        String action = req.getParameter("action");
        if (action == null) {
            showStudent(req,resp);
        } else {
            switch (action) {
                case "add":
                    // Điều hưỡng về view add(form thêm mới)
                    resp.sendRedirect("view/add-student.jsp");
                    break;
                case "edit":
                    // Lấy về id trên URL
                    String studentCode = req.getParameter("id");
                    Student studentEdit = findByStudentCode(studentCode);
                    req.setAttribute("studentEdit", studentEdit);

                    // Điều hướng về view edit
                    req.getRequestDispatcher("view/edit-student.jsp").forward(req,resp);
                    break;
                case "delete":
                    String studentID = req.getParameter("id");
                    Student studentDelete = findByStudentCode(studentID);

                    students.remove(studentDelete);
                    showStudent(req,resp);

                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set lại ký tự
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        // Lấy dữ liệu từ form gửi lên
        String studentCode = req.getParameter("studentCode");
        String studentName = req.getParameter("studentName");
        String address = req.getParameter("address");
        int age = Integer.parseInt(req.getParameter("age"));
        String classRoom = req.getParameter("classRoom");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));


        // Thêm mới
        if (action == null) {
            Student student = new Student(studentCode, studentName, address, age, classRoom, gender );
            students.add(student);
            showStudent(req,resp);
        } else {
            Student studentEdit = findByStudentCode(studentCode);

            studentEdit.setStudentName(studentName);
            studentEdit.setAddress(address);
            studentEdit.setAge(age);
            studentEdit.setClassRoom(classRoom);
            studentEdit.setGender(gender);


            showStudent(req,resp);
        }

    }

    public void showStudent (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", students);
        req.getRequestDispatcher("view/student.jsp").forward(req,resp);
    }

    public Student findByStudentCode(String studentCode) {
        for (Student student : students) {
            if (student.getStudentCode().equals(studentCode))
                return student;
        }
        return null;
    }
}

