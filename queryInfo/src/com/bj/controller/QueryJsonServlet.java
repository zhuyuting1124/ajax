package com.bj.controller;

import com.bj.dao.ProvinceDao;
import com.bj.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        //获取请求参数，省份id
        String strProid = req.getParameter("proid");
        //判断proid有值时，调用dao查询数据
        if(strProid != null && strProid.trim().length() > 0){
            ProvinceDao dao = new ProvinceDao();
            Province p = dao.queryPeovinceById(Integer.valueOf(strProid));
            //使用jackson把Province对象转换为json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(p);
        }
        //把获取的数据通过网络传给Ajax中的对象，响应结果数据
        //指定服务器端（servlet）返回给浏览器的时json格式的数据
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
