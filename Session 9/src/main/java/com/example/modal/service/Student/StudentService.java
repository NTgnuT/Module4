package com.example.modal.service.Student;

import com.example.modal.entity.Student;
import com.example.modal.service.IGenericService;

import java.util.List;

public interface StudentService extends IGenericService<Student, Integer> {
    List<Student> findByName (String name);

    List<Student> sortById ();
}
