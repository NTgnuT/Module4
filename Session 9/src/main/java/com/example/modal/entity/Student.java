package com.example.modal.entity;


import java.sql.Date;

public class Student {
    private int studentId;
    private String studentName;
    private String email;
    private Date birthday;
    private String address;

    public Student() {
    }

    public Student(int studentId, String studentName, String email, Date birthday, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
