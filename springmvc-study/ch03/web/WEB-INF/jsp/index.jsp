<%--
  Created by IntelliJ IDEA.
  User: 天文学
  Date: 2020/12/31
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎：<%=request.getSession().getAttribute("user")%>
</body>
</html>
