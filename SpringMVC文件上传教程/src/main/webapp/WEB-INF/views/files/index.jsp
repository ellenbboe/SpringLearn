<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: s
  Date: 18-11-14
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload files</title>
</head>
<body>

<form:form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit"/>
</form:form>
</body>
</html>
