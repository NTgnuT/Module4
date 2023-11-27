package com.example.modal.dao;

import com.example.modal.entity.Category;
import com.example.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            connection = ConnectionDB.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));

                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        Connection connection = null;
        if (findById(category.getCategoryId()) == null) {
            try {
                connection = ConnectionDB.openConnection();
                String sql = "INSERT INTO category(name, status) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.isCategoryStatus());

                int check = statement.executeUpdate();
                if (check > 0) {
                    return true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
        } else {
            try {
                connection = ConnectionDB.openConnection();
                String sql = "UPDATE category SET name = ?, status = ? WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.isCategoryStatus());
                statement.setInt(3, category.getCategoryId());

                int check = statement.executeUpdate();
                if (check > 0) {
                    return true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
        }

        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = null;
//        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
            preparedStatement.setInt(1,integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));

//                categories.add(category);
            }
//            for (Category category : categories) {
//                if (category.getCategoryId() == integer) {
//                    return category;
//                }
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public void delete(Integer integer) {

    }
}
