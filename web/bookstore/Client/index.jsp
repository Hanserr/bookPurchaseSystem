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
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>线上书城</title>
    <link rel="stylesheet" href="bookstore/Main/index.css" type="text/css">
    <script src="bookstore/jquery-3.5.1.js"></script>
    <script>
      $(function (){
          $(".add").click(function (){
              var bookId = $(this).attr("bookId");
              location.href = "http://localhost:8080/book/cartServlet?action=addItem&id="+bookId;
          })
      })
    </script>
</head>
<body>
    <div class="header">
        <img id="title" src="bookstore/Main/title.png" alt="标题">
       <div class="management">
        <c:if test="${empty sessionScope.user}">
            <a href="bookstore/UserLogin/loginuser.jsp">登录</a>
            <span>|</span>
            <a href="bookstore/UserRegist/regist.jsp">注册</a>
            <a href="bookstore/manager/ManagerLogin.jsp" target="_blank">后台管理</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>${sessionScope.user.username}</span>
            <a href="">我的订单</a>
            <a href="bookstore/Client/cart.jsp">购物车</a>
            <a href="userServlet?action=logout">注销</a>
        </c:if>
       </div>
    </div>
    <div class="main">
        <div class="top">
            <div id="price">
                <form action="client/clientBookServlet" method="get">
                    <input type="hidden" name="action" value="pageByPrice">
                价格:<input type="text" name="min" autocomplete="off" value="${param.min}">
                    <span>元- </span>
                    <input type="text" name="max" autocomplete="off" value="${param.max}"> 元
                <input type="submit" id="search" value="查询">
                </form>
            </div>
            <div id="cart">
                您的购物车中有<span>1</span>件商品
            </div>
        </div>
        <div class="middle">
           <c:forEach items="${requestScope.page.items}" var="book">
               <div class="framework">
                   <img src="bookstore/Main/BookPicture/1.jpg" alt="pic">
                   <div class="content">
                       <span>书名:</span><span>${book.name}</span>
                       <br>
                       <span>作者:</span><span>${book.author}</span>
                       <br>
                       <span>价格:</span><span>${book.price}</span>
                       <br>
                       <span>销量:</span><span>${book.sales}</span>
                       <br>
                       <span>库存:</span><span>${book.stock}</span>
                       <div class="addButton">
                           <form action="" method="POST">
                               <c:if test="${not empty sessionScope.user}">
                               <input type="button" class="add" value="加入购物车" bookId=${book.id}>
                               </c:if>
                           </form>
                       </div>
                   </div>
               </div>
           </c:forEach>
        </div>
        <div class="bottom">
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
    </div>
    <div class="but">
        无声明
    </div>
</body>
</html>