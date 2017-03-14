<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/12
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="/public/head.jspf" %>
    <title>adminRegist</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="管理员注册" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form:form id="ff" name="form1" method="post" modelAttribute="admin" action="regist">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><form:input class="easyui-validatebox" type="text" name="name" data-options="required:true" path="adminName"/>${userNameError}</td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><form:input class="easyui-validatebox" type="password" id="password" name="password" data-options="required:true" path="adminPwd"/></td>
                </tr>
                <tr>
                    <td>密码确认:</td>
                    <td><input class="easyui-validatebox" type="password" name="passwordagain" id="passwordagain" data-options="required:true" validType="pwdagain['#password']"/></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><form:input class="easyui-validatebox" type="text" id="email" name="email" data-options="required:true,validType:'email'" path="adminEmail"/></td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td><form:input class="easyui-validatebox" type="text" id="phone" name="phone" data-options="required:true,validType:'phone'" path="adminPhone"/></td>
                </tr>
                <tr>
                    <td>店铺名:</td>
                    <td><form:input class="easyui-validatebox" type="text" name="shop" data-options="required:true" path="shopName"/>${shopNameError}</td>
                </tr>
            </table>
        </form:form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:document.form1.submit();" class="easyui-linkbutton">注册</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="toRegist()">返回登陆</a>
        </div>
    </div>
</div>
<script typd="text/JavaScript">
    $.extend($.fn.validatebox.defaults.rules, {
        phone: {
            // 验证手机号码
            validator: function (value) {
                return /^(13|15|18)\d{9}$/i.test(value); //这里就是一个正则表达式
            },
            message: '手机号码格式不正确'           //这里是错误后的提示信息
        },
        pwdagain: {
            //两次密码是否一致
            validator: function (value, param) {
                return value == $(param[0]).val();
                //value是不用我们去填写的，但是param是需要我们提供的，使用方法为 pwdAgain[""]
            },
            message: '两次密码不一致'             //这里是错误后的提示信息
        }
    });
    function toRegist(){
        window.location = 'toLogin';
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>
