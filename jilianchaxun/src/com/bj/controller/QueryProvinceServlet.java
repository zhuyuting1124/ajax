package com.bj.controller;

import com.bj.dao.QueryDao;
import com.bj.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json="{}";
        //调用dao，获取所有省份信息，得到一个List集合
        QueryDao dao = new QueryDao();
        List<Province> provinceList = dao.queryProvinceList();
        //把list转为json格式的数据，输出Ajax请求
        if(provinceList != null){
            //调用Jackson工具库，实现list->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(provinceList);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
