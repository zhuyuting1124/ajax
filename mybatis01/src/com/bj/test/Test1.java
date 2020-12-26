package com.bj.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.bj.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        /*
        增加记录
        如果取得单条记录，个selectOne方式
       参数1：根据命名空间
       参数2：为sql传递参数
        Student s = session.selectOne("test1.getById","A0001");
        System.out.println(s);
        session.close();
         */
        /*
        查询所有记录
        List<Student> list = session.selectList("test1.getAll");
        for(Student s : list){
            System.out.println(s);
        }
        session.close();
*/
        /*
        Mybatis默认手动提交事务
        增加记录
        Student s = new Student();
        s.setAge(15);
        s.setId("A0006");
        s.setName("Lili");
        session.insert("test1.insertStu",s);
        session.commit();
        session.close();
         */
        /*
        修改记录
        Student s = new Student();
        s.setAge(17);
        s.setId("A0006");
        s.setName("Lili");
        session.update("test1.updateStu",s);
        session.commit();
        session.close();
         */
        /*
        删除记录
         */
        session.delete("com.bj.dao.StudentDao.deleteStu","A0006");
        session.commit();
        session.close();
    }
}
