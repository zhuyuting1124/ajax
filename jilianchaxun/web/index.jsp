<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/12/6
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
    <script type="text/javascript">
      function loadDataAjax(){
        //做Ajax请求，使用jQuery的$.ajax()
        $.ajax({//get()方式
          url:"queryProvince",
          dataType:"json",
          success:function(resp){
            $("#province").empty();
            $.each(resp,function(i,n){//n是json对象，[{"id":1,"name":"河北","jiancheng":"冀","省会":"石家庄"}]
              $("#province").append("<option value='" + n.id + "'>" + n.name + "</option>");
            })
          }
        })
      }

      $(function(){
        //$(function())在页面的dom对象加载成功后执行的函数，在此发起Ajax请求
        loadDataAjax();
        //绑定事件
        $("#btnload").click(function(){
          //可以是get()方式 or post()方式
          loadDataAjax();
        })
        $.post("queryCity",{proid:1},callback,"json");



        //给省份的select绑定一个change时间，当select内容发生变化时，出发事件
        $("#province").change(function(){//选项发生改变
          //获取选中的列表框中的值
          var obj = $("#province>option:selected");
          var provinceId = obj.val();
          //做一个Ajax请求，获取省份的所有城市信息
          //post()方式
          $.post("queryCity",{proid:provinceId},callback,"json");

        })

      })

      function callback(resp){
        //清空列表
        $("#city").empty();
        $.each(resp,function(i,n){

          $("#city").append("<option value='" + n.id + "'>" + n.name + "</option>");
        })
      }



    </script>
  </head>
  <body>
  <p>省市级联查询，使用ajax</p>
  <div>
    <table border="2">
      <tr>
        <td>省份</td>
        <td>
          <select id="province">
            <option value="0">请选择......</option>
          </select>
        </td>
        <td>
          <input type="button" value="load数据" id="btnload"/>
        </td>
      </tr>
      <tr>
        <td>城市</td>
        <td colspan="2">
          <select id="city">
            <option value="0">请选择......</option>
          </select>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
