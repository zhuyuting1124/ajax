package com.bj.dao;

import com.bj.entity.Province;

import java.sql.*;
//根据省份编号获取数据库查询结果
public class ProvinceDao {
    //根据id获取名称
    public String queryPeovinceNameById(Integer provinceId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="";
        String name = "";
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username ="root";
        String password = "123456";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            sql = "select name from province where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString("name");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(conn != null){
                    conn.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }


    //根据id获取一个完整的province对象
    public Province queryPeovinceById(Integer provinceId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="";
        Province province = null;
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username ="root";
        String password = "123456";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            sql = "select id, name, jiancheng, shenghui from province where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs = ps.executeQuery();
            while(rs.next()){
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(conn != null){
                    conn.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return province;
    }
}
