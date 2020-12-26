//业务层：调用dao层
package com.bj.service.impl;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.service.StudentService;
import com.bj.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //private StudentDao studentDao = new StudentDaoImpl();//多态，抽象接口
    //创建实现类
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
    @Override
    public Student getById(String id) {
        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void insertStu(Student s) {
        studentDao.insertStu(s);
    }

    @Override
    public List<Student> getAll() {
        List<Student> s = studentDao.getAll();
        return s;
    }

    @Override
    public void deleteStu(String id) {
        studentDao.deleteStu(id);
    }

    @Override
    public void updateStu(String id) {
        studentDao.updateStu(id);
    }
}
