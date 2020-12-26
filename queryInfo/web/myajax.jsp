<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/12/1
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用json格式的数据</title>
    <script type="text/javascript">
        function doSearch(){
            //1.创建异步对象
            var xmlHttp = new XMLHttpRequest();
            //2.绑定事件
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var data = xmlHttp.responseText;
                    var jsonobj = eval("("+data+")");
                    document.getElementById("proname").value = jsonobj.name;
                    document.getElementById("projiancheng").value = jsonobj.jiancheng;
                    document.getElementById("proshenghui").value = jsonobj.shenghui;
                    document.get
                }
            }
            //3.初始化
            var proid = document.getElementById("proid").value;
            xmlHttp.open("get", "queryjson?proid="+proid, true);
            //4.发送
            xmlHttp.send();
        }
    </script>
</head>
<body>
    <p>ajax请求使用json格式的数据</p>
    <table>
        <tr>
            <td>省份编号：</td>
            <td>
                <input type="text" id="proid">
                <input type="button" value="搜索" onclick="doSearch()">
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td><input type="text" id="proname"></td>
        </tr>
        <tr>
            <td>省份简称：</td>
            <td><input type="text" id="projiancheng"></td>
        </tr>
        <tr>
            <td>省会名称：</td>
            <td><input type="text" id="proshenghui"></td>
        </tr>
    </table>
</body>
</html>
