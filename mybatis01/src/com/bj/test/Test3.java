package com.bj.test;

import com.bj.dao.StudentDao;
import com.bj.util.SqlSessionUtil;

public class Test3 {
    public static void main(String[] args) {
        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    }
}
