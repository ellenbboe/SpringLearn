<%--
  Created by IntelliJ IDEA.
  User: s
  Date: 18-11-19
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script Language="JavaScript">
        function checklogin() {
            if((document.form1.loginName.value!=="")&&(document.form1.password.value!==""))
            {
                return true;
            }else{
                return false;
            }
        }

        function userlogin()
        {
            if(checklogin())
            {
                document.form1.action="/userlogin";
                document.form1.submit();
            }else{
                alert("用户名或者密码不能为空!!");
            }
        }
        function adminlogin() {

            if(checklogin())
            {
                document.form1.action="/adminlogin";
                document.form1.submit();
            }else{
                alert("用户名或者密码不能为空!!");
            }
        }
    </script>
</head>

<body>
<h1>简易设备资产管理系统</h1>
<span style="color: red">${message}</span>
<form method="post" name="form1" onsubmit="return checklogin()">
    <table>
        <tr>
            <td>
                <label for="loginName">用户名:</label>
            </td>
            <td>
                <input type="text" id="loginName" name="loginName">
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">密码:</label>
            </td>
            <td>
                <input type="password" id="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <button name="button"  onclick="adminlogin()">管理员登录</button>
            </td>
            <td>
                <a href="/register">注册</a>
            </td>
        </tr>
        <tr>
            <td>
                <button name="button" onclick="userlogin()">用户登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
