<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/11/30
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>局部刷新</title>
    <script type="text/javascript">
      //使用内存中的异步对象，代替浏览器发起请求，异步对象使用js创建和管理
      function doAjax(){
        //1创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2绑定事件
        xmlHttp.onreadystatechange = function(){
          //处理服务器端返回的数据，更新当前页面
          //alert("readyState属性值=" + xmlHttp.readyState + " | status: " + xmlHttp.status);
          if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            //alert(xmlHttp.responseText);
            var data = xmlHttp.responseText;
            //更新dom对象，更新页面数据
            document.getElementById("mydata").innerText = data;
          }
        }
        //3初始化请求数据
        var name = document.getElementById("name").value;
        var w = document.getElementById("w").value;
        var h = document.getElementById("h").value;
        var param = "name=" + name + "&w=" + w + "&h=" +h;
        alert("param=" + param);
        xmlHttp.open("get", "bmiAjax?"+param, true);//方式，地址，同步/异步
        //4发起请求
        xmlHttp.send();
      }

    </script>
  </head>
  <body>
  <p>局部刷新-计算bmi</p>
  <div>
    姓名：<input type="text" id="name"/> <br/>
    体重(公斤)：<input type="text" id="w"/> <br/>
    身高(米)：<input type="text" id="h"/> <br/>
    <input type="submit" value="计算bmi" onclick="doAjax()"><br/>
    <br/>
    <div id="mydata">等待加载对象</div>

  </div>
  </body>
</html>
