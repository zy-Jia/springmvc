<%--
  Created by IntelliJ IDEA.
  User: gyofu
  Date: 2022/1/15
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.user}
    <hr/>
    ${sessionScope.user}
    <hr/>
    ${applicationScope.user}
</body>
</html>
