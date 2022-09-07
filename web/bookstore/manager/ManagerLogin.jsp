<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="bookstore/manager/ManagerLogin.css" type="text/css">
</head>
<body>
<div class="all">
    <div class="body">
        <span id="sp">管理员登录</span>
        <form action="managerLogin" method="post">
            <input type="hidden" name="action" value="login">
            <div class="username">
                用户名 <input type="text" name="name" autocomplete="off">
            </div>
            <div class="pwd">
                密码 <input type="text" name="password"autocomplete="off">
            </div>
            <div class="footer">
                <div id="span">
                <span class="error">
                    ${requestScope.msg}
                </span>
                </div>
                <button type="submit" id="button1">登录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>