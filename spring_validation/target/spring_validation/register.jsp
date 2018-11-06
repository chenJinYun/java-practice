<%--
  Created by IntelliJ IDEA.
  User: LIBU2
  Date: 7/31/2018
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/register" method="post">

    <table>
        <tr>
            <td>username</td>
            <td><input type="text" name="username"></td>
            <td>${error_username}</td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"></td>
            <td>${error_password}</td>
        </tr>
        <tr>
            <td>age</td>
            <td><input type="text" name="age"></td>
            <td>${error_age}</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>

</form>

</body>
</html>
