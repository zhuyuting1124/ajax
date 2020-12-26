package com.bj.service;

import com.bj.domain.Student;

import java.util.List;

public interface StudentService {
    public Student getById(String id);
    public void insertStu(Student s);
    public List<Student> getAll();
    public void deleteStu(String id);
    public void updateStu(String id);
}
