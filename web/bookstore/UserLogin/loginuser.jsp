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
    <link rel="stylesheet" href="bookstore/UserLogin/loginuser.css" type="text/css">
</head>
<body>
    <div class="all">
    <div class="body">
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="login">
        <p>欢迎回到温暖小窝♪(^∇^*)</p>
        <div class="username">
            用户名 <input type="text" name="username" autocomplete="off" value="${requestScope.username}">
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
            <a id="a1" href="bookstore/UserLogin/loginphone.jsp">点我使用验证码登录</a>
            <a id="a2" href="bookstore/UserRegist/regist.jsp">还未注册？点我注册吧！</a>
        </div>
        </form>
    </div>
    </div>
</body>
</html>