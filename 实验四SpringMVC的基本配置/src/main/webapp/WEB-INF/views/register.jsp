<%--
  Created by IntelliJ IDEA.
  User: s
  Date: 18-11-19
  Time: 上午11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>register</title>
    <script>
        function validateform(){
            var p1 = document.form1.validatepassword.value;
            var p2 = document.form1.password.value;
            if(p1 !== p2)
            {
                document.getElementById("tip").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled=true;
            }else{
                document.getElementById("tip").innerHTML="";
                document.getElementById("submit").disabled=false;
            }
        }

        function validatephone(){
            var phoneReg = /^1[34578]\d{9}$/;
            var phone = document.getElementById("tel").value;
            if(!phoneReg.test(phone))
            {
                document.getElementById("tip2").innerHTML="<font color='red'>手机格式不符合要求</font>";
                document.getElementById("submit").disabled=true;
            }else{
                document.getElementById("tip2").innerHTML="";
                document.getElementById("submit").disabled=false;
            }
        }

    </script>
</head>
<body>
<span style="color: red">${message}</span>
<form name="form1" action="/register" method="post">
    <table>
        <tr>
            <td>
                <label for="loginName">用户名:</label>
            </td>
            <td>
                <input id="loginName" type="text" name="loginName" required>
            </td>
        </tr>
      <tr>
            <td>
                <label for="password">密码:</label>
            </td>
            <td>
                <input id="password" type="password" name="password" required>
            </td>
        </tr>
      <tr>
            <td>
                <label for="validatepassword">密码确认:</label>
            </td>
            <td>
                <input name="validatepassword" type="password" id="validatepassword" onkeyup="validateform()" required><span id="tip"></span>
            </td>
        </tr>
      <tr>
            <td>
                <label for="realName">真实姓名:</label>
            </td>
            <td>
                <input type="text" id="realName" name="realName" required>
            </td>
        </tr>
      <tr>
            <td>
                <label for="tel">联系电话</label>
            </td>
            <td>
                <input type="tel" id="tel" name="tel" onkeyup="validatephone()" required><span id="tip2"></span>
            </td>
        </tr>
      <tr>
            <td>
                <label for="email">电子邮件</label>
            </td>
            <td>
                <input type="email" id="email" name="email" required>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册" id="submit">
            </td>
            <td>
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
