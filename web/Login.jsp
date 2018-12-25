<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>please login!</title>
</head>

<body>
<div>
    <h3>请登录：</h3><br>
    <form action="login.sc" name="loginForm">
        <div>账  号：<input type="text" name="id" /></div>
        <div>密  码：<input type="password" name="password" /></div>
        <div><input type="submit" name="login" value="登录" /></div>
    </form>
    <div>
        <font color="red">${sessionScope.loginMessage }</font>
    </div>
    <br>
    <div>
        如果您还不是我们的用户，请<a href="/Regist.jsp">点击注册</a>
    </div>
    <form action="logout.sc" name="xxForm">
        <div>账  号：<input type="text" name="id" /></div>
        <div><input type="submit" name="xx" value="删除账号" /></div>
    </form>
    <%
        session.removeAttribute("loginMessage");
    %>
</div>
</body>
</html>