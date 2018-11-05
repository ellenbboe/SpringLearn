<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理之-密码</title>
</head>
<body>

<h2>用户信息</h2>
<form:form method="POST" action="/adduser">
    <table>
        <tr>
            <td><form:label path="username">用户名：</form:label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><form:label path="password">密码：</form:label></td>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>