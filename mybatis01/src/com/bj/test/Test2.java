package com.bj.test;

import com.bj.domain.Student;
import com.bj.service.StudentService;
import com.bj.service.impl.StudentServiceImpl;
import com.bj.util.ServiceFactory;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //创建业务，业务层对象
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        /*
        Student s = new Student();
        s.setId("A0008");
        s.setName("Api");
        s.setAge(24);
        studentService.insertStu(s);
         */
        //添加


        /*
        //查询记录
        Student s = studentService.getById("A0001");
        System.out.println(s);
         */



        /*

         */
        //查询所有结果
        List<Student> student = studentService.getAll();
        for(Student s : student){
            System.out.println(s);
        }


        /*
        //删除记录
studentService.deleteStu("A0007");
         */

        /*
        //更新记录
        Student s = new Student();
        s.setId("A0007");
        s.setName("Api");
        s.setAge(24);
        studentService.updateStu(s);
         */

    }
}
