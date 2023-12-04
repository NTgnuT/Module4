package com.example.model.dao;

import com.example.model.entity.Customer;
import com.example.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CustomerDAO_IMPL implements ICustomerDAO {
    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_BY_NAME_CUS(?)");
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return customers;
    }

    @Override
    public List<Customer> findAll() {
            List<Customer> customers = new ArrayList<>();
            Connection connection = ConnectionDB.openConnection();
            try {
                CallableStatement callableStatement = connection.prepareCall("CALL SHOW_CUS()");
                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setAddress(resultSet.getString("address"));

                    customers.add(customer);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
            return customers;
    }

    @Override
    public boolean save(Customer customer) {
        Connection connection = ConnectionDB.openConnection();
        int check;
        CallableStatement callableStatement;
        try {
            if (customer.getId() == 0) {
                callableStatement = connection.prepareCall("CALL CREATE_CUS(?, ?, ?)");
                callableStatement.setString(1, customer.getName());
                callableStatement.setString(2, customer.getEmail());
                callableStatement.setString(3, customer.getAddress());
            } else {
                callableStatement = connection.prepareCall("CALL EDIT_CUS(?, ?, ?, ?)");
                callableStatement.setString(1, customer.getName());
                callableStatement.setString(2, customer.getEmail());
                callableStatement.setString(3, customer.getAddress());
                callableStatement.setInt(4, customer.getId());
            }
            check = callableStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL DELETE_CUS(?)");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public Customer findById(Integer integer) {
        Customer customer = new Customer();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_BY_ID_CUS(?)");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return customer;
    }
}
