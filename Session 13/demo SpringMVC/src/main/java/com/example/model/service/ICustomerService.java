package com.example.model.service;

import com.example.model.entity.Customer;

import java.util.List;

public interface ICustomerService extends IGenericService<Customer, Integer> {
    List<Customer> findByName (String name);
}
