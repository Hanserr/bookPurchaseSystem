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
    <title>Document</title>
    <link rel="stylesheet" href="bookstore/manager/WelcomeMa.css" type="text/css">
</head>
<body>
    <div id="top">
       <span>图书管理系统</span>
       <div id="right">
           <a href="manager/bookServlet?action=page">图书管理</a>
           <a href="#">订单管理</a>
           <a href="index.jsp">返回商城</a>
       </div>
    </div>
    <div id="middle">
        <div id="content">
            <span>欢迎使用管理员系统</span>
        </div>
        </div>
    </div>
    <div id="botton">
    <div id="cp">
        <span>线上书店 2020 copyright</span>
    </div>
    </div>
</body>
</html>