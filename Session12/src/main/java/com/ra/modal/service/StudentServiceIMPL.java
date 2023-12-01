package com.ra.modal.service;

import com.ra.modal.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements StudentService{
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn A", 20, true));
        students.add(new Student(2, "Nguyễn B", 25, true));
        students.add(new Student(3, "Nguyễn C", 23, false));
        return students;
    }
}
