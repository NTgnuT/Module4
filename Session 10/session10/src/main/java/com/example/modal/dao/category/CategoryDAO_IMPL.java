package com.example.modal.dao.category;

import com.example.modal.entity.Category;
import com.example.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO_IMPL implements CategoryDAO {

    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("CALL SHOW_CATEGORY()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));

                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        Connection connection = ConnectDB.openConnection();
        CallableStatement callableStatement;
        int check;

        try {
            if (category.getCategoryId() == 0) {
                callableStatement = connection.prepareCall("CALL CREATE_CATEGORY(?, ?)");
                callableStatement.setString(1, category.getCategoryName());
                callableStatement.setBoolean(2, category.isStatus());

                check = callableStatement.executeUpdate();
            } else {
                callableStatement = connection.prepareCall("CALL UPDATE_CATEGORY(?, ?, ?)");
                callableStatement.setInt(1, category.getCategoryId());
                callableStatement.setString(2, category.getCategoryName());
                callableStatement.setBoolean(3, category.isStatus());

                check = callableStatement.executeUpdate();
            }

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }

        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = ConnectDB.openConnection();
        Category category = new Category();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_CATEGORY(?)");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = ConnectDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL DELETE_CATEGORY(?)");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
    }
}
