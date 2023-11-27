package com.example.service.customer;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService{
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nguyễn A", "a@gmail.com", "Hà Nội"));
        customerList.add(new Customer(2, "Nguyễn B", "b@gmail.com", "Hạ Long"));
        customerList.add(new Customer(3, "Nguyễn C", "c@gmail.com", "Hà Nam"));
        customerList.add(new Customer(4, "Nguyễn D", "d@gmail.com", "Thanh Hóa"));
        customerList.add(new Customer(5, "Nguyễn E", "e@gmail.com", "Cao Bằng"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Customer ediCustomer = findById(customer.getId());
        if (ediCustomer == null) {
            customerList.add(customer);
        } else {
            customerList.set(customerList.indexOf(ediCustomer), customer);
        }
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(findById(id));
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                customerList.add(customer);
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int newID = 0;
        for (Customer customer : customerList) {
            if (customer.getId() > newID) {
                newID = customer.getId();
            }
        }
        return newID + 1;
    }
}
