package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    void save (T t);
    void deleteById(int id);
    T findById (int id);
    List<T> findByName (String name);
    int getNewId();
}
