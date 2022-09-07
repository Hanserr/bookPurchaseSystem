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
    <title>祝贺</title>
</head>
<link rel="stylesheet" href="bookstore/UserRegist/registSuccess.css" type="text/css">
<body>
<div id="body">
<a href="bookstore/UserLogin/loginuser.jsp">点击返回登陆界面</a>
</div>
</body>
</html>