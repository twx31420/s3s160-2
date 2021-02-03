<%--
  Created by IntelliJ IDEA.
  User: 天文学
  Date: 2021/1/8
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>文件列表</h2>
<c:forEach items="${fileNames}" var="name">
    <a href="download?fileName=${name}">${name}</a><br>
</c:forEach>

</body>
</html>
