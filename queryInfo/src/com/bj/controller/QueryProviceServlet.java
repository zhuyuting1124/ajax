package com.bj.controller;

import com.bj.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProviceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理get请求
        String strproid = req.getParameter("proid");
        System.out.println(strproid);
        //访问数据库
        String name = "无数据";
        if(strproid != null && !"".equals(strproid.trim())){
            ProvinceDao dao = new ProvinceDao();
            name = dao.queryPeovinceNameById(Integer.valueOf(strproid));
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(name);
        pw.flush();
        pw.close();
    }
}
