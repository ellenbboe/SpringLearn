<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理之文本域</title>
</head>
<body>

<h2>提交的用户信息</h2>
<table>
    <tr>
        <td>用户名：</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>地址：</td>
        <td>${address}</td>
    </tr>
    <tr>
        <td>订阅：</td>
        <td>${recivepaper}</td>
    </tr>
    <tr>
        <td>喜欢的技术/框架</td>
        <td>
            <% String[] favoriteFrameworks = (String[])request.getAttribute("favorites");
            for(String framework: favoriteFrameworks) {
                out.println(framework);
            }
        %></td>
    </tr>
</table>
</body>
</html>