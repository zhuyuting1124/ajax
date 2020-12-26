package com.bj.controller;

import com.bj.dao.QueryDao;
import com.bj.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class QueryCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应post请求方式
        //获取请求传过来的省份id
        String json = "{}";
        String strProvinceId = request.getParameter("proid");
        List<City> cityList = new ArrayList<>();
        if(strProvinceId != null && !"".equals(strProvinceId.trim())){
            QueryDao dao = new QueryDao();
            cityList = dao.queryCityList(Integer.valueOf(strProvinceId));
            //list->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cityList);
        }
        //输出数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
