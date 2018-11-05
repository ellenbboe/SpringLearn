<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
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
            <td><form:label path="address">地址：</form:label></td>
            <td><form:textarea path="address" rows="5" cols="30" /></td>
        </tr>
        <tr>
            <td><form:label path="recivepaper">订阅新闻？</form:label></td>
            <td><form:checkbox path="recivepaper" /></td>
        </tr>
        <tr>
            <td><form:label path="favorites">框架: </form:label></td>
            <td> <form:checkboxes items="${webFrameworkList}" path="favorites" /></td>
        </tr>
        <tr>
            <td><form:label path="gender">性别: </form:label></td>
            <td><form:radiobutton path="gender" value="M" label="男" />
            <form:radiobutton path="gender" value="F" label="女" /></td>
        </tr>
        <tr>
            <td><form:label path="lucknumber">数字: </form:label></td>
            <td><form:radiobuttons path="lucknumber" items="${numberlist}"/></td>
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