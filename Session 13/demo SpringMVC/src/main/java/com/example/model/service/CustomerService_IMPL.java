package com.example.model.service;

import com.example.model.dao.ICustomerDAO;
import com.example.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService_IMPL implements ICustomerService {
    @Autowired
    ICustomerDAO customerDAO;
    @Override
    public List<Customer> findByName(String name) {
        return customerDAO.findByName(name) ;
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public boolean save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public void delete(Integer integer) {
        customerDAO.delete(integer);
    }

    @Override
    public Customer findById(Integer integer) {
        return customerDAO.findById(integer);
    }
}
