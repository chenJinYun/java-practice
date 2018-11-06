<%--
  Created by IntelliJ IDEA.
  User: CHENKI
  Date: 7/25/2018
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h3>登录</h3>
    <form action="/list/login" method="get">
        用户名：<input type="text" name="name" class="name1">
        密码：<input type="text" name="password" class="password2">
        <button class="login" type="submit">提交</button>
    </form>
</div>
<a href="/list/findAllList">查询</a>
</body>
</html>
