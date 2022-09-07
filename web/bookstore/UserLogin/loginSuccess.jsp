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
    <title>欢迎</title>
    <link rel="stylesheet" href="bookstore/UserLogin/loginSuccsee.css" type="text/css">
</head>
<body>
    <div id="top">
        <img src="bookstore/Main/title.png" alt="title">
        <div id="content">
        <span>欢迎</span>
        <span id="name">${sessionScope.user.username}</span>
        <span>光临线上书城</span>
        <a href="">我的订单</a>
        <a href="userServlet?action=logout">注销</a>
        <a href="">返回</a>
        </div>
    </div>
    <div id="middle">
        <div id="content">
            <span>欢迎回来</span>
            <a href="index.jsp">返回首页</a>
        </div>
    </div>
    <div id="bottom">
        <span>陈睿资本主义书城©2012</span>
    </div>
</body>
</html>