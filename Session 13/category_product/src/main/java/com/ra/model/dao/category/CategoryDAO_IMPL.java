package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAO_IMPL implements CategoryDAO{
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = ConnectionDataBase.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL SHOW_CATE()");
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
            ConnectionDataBase.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public Category findById(Integer id) {
        Category category = new Category();
        Connection connection = ConnectionDataBase.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_BY_ID_CATE(?)");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return category;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        Connection connection = ConnectionDataBase.openConnection();
        int check;
        CallableStatement callableStatement;
        try {
            if (category.getCategoryId() == 0) {
                callableStatement = connection.prepareCall("CALL ADD_CATE(?, ?)");
                callableStatement.setString(1, category.getCategoryName());
                callableStatement.setBoolean(2, category.isStatus());

                check = callableStatement.executeUpdate();
            } else {
                callableStatement = connection.prepareCall("CALL EDIT_CATE(?, ?, ?)");
                callableStatement.setString(1, category.getCategoryName());
                callableStatement.setBoolean(2, category.isStatus());
                callableStatement.setInt(3, category.getCategoryId());
                check = callableStatement.executeUpdate();
            }
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL change_status_cate(?)");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }
}
