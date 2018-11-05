<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC处理(隐藏字段)</title>
</head>
<body>

<h2>学生信息：</h2>
<form:form method="POST" action="/addstudent">
    <table>
        <tr>
            <td><form:label path="name">学生姓名：</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">年龄：</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td></td>
            <td><form:hidden path="id" value="1000" /></td>
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