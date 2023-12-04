package com.example.model.dao;

import com.example.model.entity.Customer;

import java.util.List;

public interface ICustomerDAO extends IGenericDAO<Customer, Integer> {
    List<Customer> findByName (String name);
}
