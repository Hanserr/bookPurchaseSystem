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
    <title>修改图书</title>
    <link rel="stylesheet" href="bookstore/manager/updateBook.css">
</head>
<body>
    <div id="top">
       <span>修改图书</span>
       <div id="right">
           <a href="manager/bookServlet?action=page">图书管理</a>
           <a href="">订单管理</a>
           <a href="index.jsp">返回商城</a>
       </div>
    </div>
    <div id="middle">
        <div class="title">
           <span>名称</span>
           <span>价格</span> 
           <span>作者</span>
           <span>销量</span>
           <span>库存</span>
        </div>
        <hr>
        <div id="inp">
            <form action="manager/bookServlet" method="get">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <input type="hidden" name="id" value="${requestScope.book.id}">
            <input type="text" name="name" autocomplete="off" id="name" value="${requestScope.book.name}">
            <input type="text" name="price"autocomplete="off" id="price" value="${requestScope.book.price}">
            <input type="text" name="author" autocomplete="off" id="author" value="${requestScope.book.author}">
            <input type="text" name="sales" autocomplete="off" id="sales" value="${requestScope.book.sales}">
            <input type="text" name="stock" autocomplete="off" id="stock" value="${requestScope.book.stock}">
            <input type="submit" value="修改图书">
        </form>
    </div>
    <hr>
    </div>
    <div id="botton">
    <div id="cp">
        <span>线上书店 2020 copyright</span>
    </div>
    </div>
</body>
</html>