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
    <title>购物车</title>
    <link rel="stylesheet" href="bookstore/Client/cart.css">
</head>
<script src="bookstore/jquery-3.5.1.js"></script>
<script type="text/javascript">
         $(function () {
            $("a.delete").click(function () {
            return confirm("你确定要删除《"+$(this).parent().find(".name").find("span").text()+"》吗?");
            })

         $(".clear").click(function () {
             return confirm("你确定要删除清空购物车吗?");
         })

         $("div.minus").click(function(){
         if($(this).parent().find(".txt").find(".value").val() == 1){
             if (confirm("当前商品数量已是最小值，是否删除？")){
             location.href = "cartServlet?action=DeleteItem&id="+$(this).parent().parent().parent().find("#inp").val();
             }else{
                 return false;
             }
         }else if($(this).parent().find(".txt").find(".value").val() >=2){
             $(this).parent().find(".txt").find(".value").val(parseInt($(this).parent().find(".txt").find(".value").val())-1);
             location.href = "cartServlet?action=updateCount&id="+$(this).parent().parent().parent().find("#inp").val()+"&count="+ $(this).parent().find(".txt").find(".value").val();
         }
     })
         $("div.plus").click(function(){
             if($(this).parent().find(".txt").find(".value").val()<parseInt($(this).parent().parent().parent().find("#stock").val())){
                 $(this).parent().find(".txt").find(".value").val(parseInt($(this).parent().find(".txt").find(".value").val())+1);
                 location.href = "cartServlet?action=updateCount&id="+$(this).parent().parent().parent().find("#inp").val()+"&count="+ $(this).parent().find(".txt").find(".value").val();
             }else {
                 alert("已达最大可购买量")
             }
         })
         $(".value").blur(function (){
             if(parseInt($(this).val())>parseInt($(this).parent().parent().parent().parent().find("#stock").val())){
                 $(this).val(parseInt($(this).parent().parent().parent().parent().find("#stock").val()));
                 location.href = "cartServlet?action=updateCount&id="+$(this).parent().parent().parent().parent().find("#inp").val()+"&count="+ $(this).val();
             }else{
                 location.href = "cartServlet?action=updateCount&id="+$(this).parent().parent().parent().parent().find("#inp").val()+"&count="+ $(this).val();
             }
         })
    })
</script>
<body>
    <div id="top">
       <span>购物车</span>
       <div id="right">
           <a href="">返回商城</a>
       </div>
    </div>
    <div id="middle">
        <c:if test="${not empty sessionScope.cart.items}">
        <div class="title">
            <span>商品名称</span>
            <span>数量</span>
            <span>单价</span>
            <span>金额</span>
            <span>操作</span>
        </div>
        <hr>
        </c:if>
        <c:if test="${empty sessionScope.cart.items}">
            <span class="point">购物车居然是空的？不买点东西？</span>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
        <div class="contain">
            <input type="hidden" value="${entry.value.stock}" id="stock">
            <input type="hidden" value="${entry.value.id}" id="inp">
            <div class="name"><span>${entry.value.name}</span></div>
            <div class="sum">
                <div class="update">
                    <div class="minus"><span>-</span></div>
                    <div class="txt"><input type="text"  class="value" maxlength="6" min="1" value="${entry.value.count}"></div>
                    <div class="plus"><span>+</span></div>
                </div>
            </div>
            <div class="price"><span>${entry.value.price}</span></div>
            <div class="TotalPrice"><span>${entry.value.price}</span></div>
            <a href="cartServlet?action=DeleteItem&id=${entry.value.id}" class="delete">删除</a>
        </div>
        <hr>
        </c:forEach>

        <c:if test="${not empty sessionScope.cart.items}">
        <div class="bottom">
           购物车中共有:<span style="color: #e7947b;font-size: 20px;">${sessionScope.cart.totalCount}</span>件商品
           总金额:<span style="color: #e7947b;font-size: 20px;">${sessionScope.cart.totalPrice}</span>元
           <a href="cartServlet?action=clear" class="clear">清空购物车</a>
           <a href="">去结账</a>
        </div>
        </c:if>

    </div>
    <div id="cp">
        <span>线上书店 2020 copyright</span>
    </div>
</body>
</html>