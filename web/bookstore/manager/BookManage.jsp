<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
        request.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理系统</title>
    <link rel="stylesheet" href="bookstore/manager/BookManage.css" type="text/css">
</head>
<script src="bookstore/jquery-3.5.1.js"></script>
<script>
    $(function () {
    $("a.check").click(function () {
    return confirm("你确定要删除《"+$(this).parent().parent().find("div:eq(1)").find("span").text()+"》吗?")
    })
    })
</script>
<body>
    <div id="top">
       <span>图书管理系统</span>
       <div id="right">
           <a href="">订单管理</a>
           <a href="index.jsp">返回商城</a>
           <a href="bookstore/manager/BookEdit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a>
       </div>
    </div>
    <div id="middle">
        <div class="title">
           <span>ID</span>
           <span>名称</span>
           <span>价格</span> 
           <span>作者</span>
           <span>销量</span>
           <span>库存</span>
           <span>操作</span>
        </div>
        <hr>
        <c:forEach items="${requestScope.page.items}" var="book">
        <div class="contain">
            <div class="ID"><span class="ID">${book.id}</span></div>
            <div class="name"><span class="name">${book.name}</span></div>
            <div class="price"><span class="price">${book.price}</span></div>
            <div class="author"><span class="author">${book.author}</span></div>
            <div class="sales"><span class="sales">${book.sales}</span></div>
            <div class="stock"><span class="stock">${book.stock}</span></div>
           <div id="operate">
            <a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a>
            <a class="check" href="manager/bookServlet?action=delete&id=${book.id}">删除</a>
           </div>
        </div>
        <hr>
        </c:forEach>
        <div class="search">
            <br>
            <c:if test="${requestScope.page.pageNo>1}">
            <a href="${requestScope.page.url}&pageNo=1">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            <span>${requestScope.page.pageNo-1}</span>
            </c:if>
            <span>【${requestScope.page.pageNo}】</span>
            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
            <span>${requestScope.page.pageNo+1}</span>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
            </c:if>
            共<span>${requestScope.page.pageTotal}</span>页
            <span> ${requestScope.page.pageTotalCount}条记录</span>
            <input type="number" id="input" oninput="if(value>${requestScope.page.pageTotal})value=${requestScope.page.pageTotal};if(value<1)value=1">页
            <script>
                $(function () {
                    $("#sure").click(function () {
                        var pageNo = $("#input").val();
                        location.href="${basePath}${requestScope.page.url}&pageNo="+pageNo;
                    })
                })
            </script>
            <input type="button" id="sure" value="确定">
        </div>
    </div>
    <div id="botton">
    <div id="cp">
        <span>线上书店 2020 copyright</span>
    </div>
    </div>
</body>
</html>