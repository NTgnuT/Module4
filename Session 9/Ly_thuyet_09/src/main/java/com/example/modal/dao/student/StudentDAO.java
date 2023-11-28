package com.example.modal.dao.student;

import com.example.modal.dao.IGenericDAO;
import com.example.modal.entity.Student;

import java.util.List;

public interface StudentDAO extends IGenericDAO<Student, Integer> {
    List<Student> findByName (String name);

    List<Student> sortById ();
}
