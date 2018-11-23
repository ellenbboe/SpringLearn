<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: s
  Date: 18-11-20
  Time: 下午8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        textarea{
            width: 500px;
        }
    </style>
</head>
<body>
<h1>简易设备资产管理系统</h1>
<span style="color: red">${message}</span>

<span>欢迎【${sessionScope.admin.realName}】,
    【<c:if test="${sessionScope.admin.type==0}">系统管理员</c:if>
<c:if test="${sessionScope.admin.type==1}">普通用户</c:if>】使用设备资产管理系统</span>
    <a href="/logout">退出</a>
    <div style="width: 520px; border: 2px solid grey;padding-left: 10px;margin-bottom: 10px">
    <form action="/register/equipment" method="post">
        <label for="name">名称</label>
        <input name="name" id="name" type="text">
        <label for="code">编码</label>
        <input name="code" id="code" type="text"><br>
        <label for="price" >价格</label>
        <input name="price" id="price" type="text"><br>
        <label for="description">描述</label>
        <textarea name="description" id="description" rows="3" cols="20"></textarea><br>
        <label for="userId">领用人</label>
        <select name="userId" id="userId">
            <c:forEach var="user" items="${sessionScope.list}">
                <option value ="${user.key}">${user.value}</option>
            </c:forEach>
        </select>
        <label for="place">存放地点</label>
        <input name="place" id="place" type="text">
        <input type="submit" value="添加设备"/>
    </form>
    </div>
    <table border="1" cellspacing="0">
        <tr>
            <th>序号</th>
            <th>资产编码</th>
            <th>名称</th>
            <th>价格</th>
            <th>存放地点</th>
            <th>领用人</th>
            <th>领用时间</th>
        </tr>
        <c:forEach var="item" items="${equipments}">

            <tr>
                <td>${item.key.id}</td>
                <td><c:out value="${item.key.code}"></c:out></td>
                <td><c:out value="${item.key.name}"></c:out></td>
                <td><c:out value="${item.key.price}"></c:out></td>
                <td><c:out value="${item.key.place}"></c:out></td>
                <td>${item.value}</td>
                <td><c:out value="${item.key.addTime}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
