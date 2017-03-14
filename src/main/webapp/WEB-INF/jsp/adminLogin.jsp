<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/12
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="/public/head.jspf" %>
    <title>adminlogin</title>
</head>
<body>

<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="管理登录" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form:form id="ff" name="form1" method="post" modelAttribute="admin" action="login">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><form:input class="easyui-textbox" type="text" name="name" data-options="required:true" path="adminName"/>${usernameerror}</td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><form:input class="easyui-textbox" type="password" name="pwd" data-options="required:true" path="adminPwd"/>${passworderror}</td>
                </tr>
            </table>
        </form:form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:document.form1.submit();" class="easyui-linkbutton">登陆</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="toRegist()">注册</a>
        </div>
    </div>
</div>
<script>
    function toRegist(){
        window.location = 'toRegist';
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>
