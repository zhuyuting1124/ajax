<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/11/30
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新</title>
  </head>
  <body>
    <p>全局刷新计算bmi</p>
    <form action = "bmiServlet" method = "get">
      姓名:<input type="text" name="name"> <br/>
      体重(公斤):<input type="text" name="w"> <br/>
      身高(米):<input type="text" name="h"> <br/>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
