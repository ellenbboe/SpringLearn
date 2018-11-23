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
</head>
<body>
<h1>简易设备资产管理系统</h1>
<div>
<span>欢迎【${sessionScope.user.realName}】,
    【<c:if test="${sessionScope.user.type==0}">系统管理员</c:if>
<c:if test="${sessionScope.user.type==1}">普通用户</c:if>】使用设备资产管理系统</span>
    <a href="/logout">退出</a>
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
    <c:forEach var="equipment" items="${equipments}">
        <tr>
            <td>${equipment.id}</td>
            <td><c:out value="${equipment.code}"></c:out></td>
            <td><c:out value="${equipment.name}"></c:out></td>
            <td><c:out value="${equipment.price}"></c:out></td>
            <td><c:out value="${equipment.place}"></c:out></td>
            <td>${sessionScope.user.realName}</td>
            <td><c:out value="${equipment.addTime}"></c:out></td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
