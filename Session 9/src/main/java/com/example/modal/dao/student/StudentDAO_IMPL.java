package com.example.modal.dao.student;

import com.example.modal.entity.Student;
import com.example.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_IMPL implements StudentDAO {
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.Openconnection();
            CallableStatement callableStatement = connection.prepareCall("CALL SHOW_STUDENT()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    @Override
    public boolean save(Student student) {
        Connection connection = ConnectionDB.Openconnection();
        int check;
        CallableStatement callableStatement;
        try {
            if (student.getStudentId() == 0) {
                callableStatement = connection.prepareCall("CALL PRO_CREATE_STUDENT(?, ?, ?, ?) ");
                callableStatement.setString(1, student.getStudentName());
                callableStatement.setString(2, student.getEmail());
                callableStatement.setDate(3, student.getBirthday());
                callableStatement.setString(4, student.getAddress());

                check = callableStatement.executeUpdate();
            } else {
                callableStatement = connection.prepareCall("CALL PRO_EDIT_STUDENT(?, ?, ?, ?, ?)");
                callableStatement.setInt(1, student.getStudentId());
                callableStatement.setString(2, student.getStudentName());
                callableStatement.setString(3, student.getEmail());
                callableStatement.setDate(4, student.getBirthday());
                callableStatement.setString(5, student.getAddress());

                check = callableStatement.executeUpdate();
            }

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Student findById(Integer integer) {
        Connection connection = null;
        Student student = new Student();
        try {
            connection = ConnectionDB.Openconnection();
            CallableStatement callableStatement = connection.prepareCall("CALL SHOW_STUDENT_BY_ID(?)");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.CloseConnection(connection);
        }
        return student;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        try {
            connection = ConnectionDB.Openconnection();
            CallableStatement callableStatement = connection.prepareCall("CALL PRO_DELETE_STUDENT(?)");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.CloseConnection(connection);
        }
    }

    @Override
    public List<Student> findByName(String name) {
        Connection connection = null;
        List<Student> students = new ArrayList<>();

        try {
            connection = ConnectionDB.Openconnection();
            CallableStatement callableStatement = connection.prepareCall("CALL FIND_STUDENT(?)");
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.CloseConnection(connection);
        }
        return students;
    }

    @Override
    public List<Student> sortById() {
        Connection connection = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.Openconnection();
            CallableStatement callableStatement = connection.prepareCall("CALL SORT_STUDENT()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.CloseConnection(connection);
        }
        return students;
    }
}
