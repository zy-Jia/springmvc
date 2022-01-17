<%--
  Created by IntelliJ IDEA.
  User: gyofu
  Date: 2022/1/16
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="person" action="/validator/register2" method="post">
        用户名: <form:input path="username"/><form:errors path="username"/><br/>
        密码: <form:password path="password"/><form:errors path="password"/><br/>
        邮箱: <form:input path="email"/><form:errors path="email"/><br/>
        电话: <form:input path="phone"/><form:errors path="phone"/><br/>
        <input type="submit" value="提交"/>
    </form:form>
</body>
</html>