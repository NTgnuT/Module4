package com.example.modal.dao.product;

import com.example.modal.dao.category.CategoryDAO;
import com.example.modal.dao.category.CategoryDAO_IMPL;
import com.example.modal.entity.Product;
import com.example.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDAO_IMPL implements ProductDAO {
    public static CategoryDAO categoryDAO = new CategoryDAO_IMPL();

    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("CALL SHOW_PRODUCT()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setCategory(categoryDAO.findById(resultSet.getInt("category_id")));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = ConnectDB.openConnection();
        int check;
        CallableStatement callableStatement;

        try {
            connection.setAutoCommit(false);
            if (product.getProductId() == 0) {
                callableStatement = connection.prepareCall("CALL CREATE_PRODUCT(?, ?, ?)");
                callableStatement.setString(1, product.getProductName());
                callableStatement.setInt(2, product.getPrice());
                callableStatement.setInt(3, product.getCategory().getCategoryId());

            } else {
                callableStatement = connection.prepareCall("CALL UPDATE_PRODUCT(?, ?, ?, ?)");
                callableStatement.setInt(1, product.getProductId());
                callableStatement.setString(2, product.getProductName());
                callableStatement.setInt(3, product.getPrice());
                callableStatement.setInt(4, product.getCategory().getCategoryId());

            }
            check = callableStatement.executeUpdate();
            if (check > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }

        return false;
    }

    @Override
    public Product findById(Integer integer) {
        Connection connection = ConnectDB.openConnection();
        Product product = new Product();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_PRODUCT(?)");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setCategory(categoryDAO.findById(resultSet.getInt("category_id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = ConnectDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL DELETE_PRODUCT(?)");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
          ConnectDB.closeConnection(connection);
        }
    }
}
