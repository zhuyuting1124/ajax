package com.bj.dao;

import com.bj.entity.City;
import com.bj.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private String url="jdbc:mysql://localhost:3306/springdb";
    private String username = "root";
    private String password = "123456";
    //查询所有省份信息
    public List<Province> queryProvinceList(){
        List<Province> provinceList = new ArrayList<>();

        sql = "select id,name,jiancheng,shenghui from province order by id";
        try {
            Province province = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
                provinceList.add(province);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provinceList;

    }

    public List<City> queryCityList(Integer provinceId){
        List<City> cityList = new ArrayList<>();
        sql = "select id,name from city where provinceid = ? ";
        try {
            City city = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs = ps.executeQuery();
            while(rs.next()){
                city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cityList.add(city);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cityList;

    }
}
