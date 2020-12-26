package com.bj.dao;

import com.bj.domain.Student;

import java.util.List;

public interface StudentDao {
    public Student getById(String id);
    public void insertStu(Student s);
    List<Student> getAll();
    void deleteStu(String id);
    void updateStu(String id);
}
