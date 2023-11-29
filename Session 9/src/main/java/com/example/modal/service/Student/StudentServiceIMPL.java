package com.example.modal.service.Student;

import com.example.modal.dao.student.StudentDAO;
import com.example.modal.dao.student.StudentDAO_IMPL;
import com.example.modal.entity.Student;

import java.util.List;

public class StudentServiceIMPL implements StudentService{
    private final StudentDAO studentDAO = new StudentDAO_IMPL();
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student findById(Integer integer) {
        return studentDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        studentDAO.delete(integer);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDAO.findByName(name);
    }

    @Override
    public List<Student> sortById() {
        return studentDAO.sortById();
    }
}
