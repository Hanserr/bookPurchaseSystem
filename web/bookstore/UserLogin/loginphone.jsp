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
    <link rel="stylesheet" href="bookstore/UserLogin/loginphone.css" type="text/css">
    <script src="bookstore/jquery-3.5.1.js"></script>
    <script>
        $(function(){
            var regphone = /^1[345678]\d{9}$/;
            var str1 = " <img class='str' src='bookstore/UserRegist/right.png' style='width: 15px;height: 15px;vertical-align: middle;'>";
            var str2 = " <img class='str' src='bookstore/UserRegist/wrong.png' style='width: 15px;height: 15px;vertical-align: middle;'>";
             //手机号输入框失焦事件
            $("#phon").blur(function(){
               if($.trim($("#phon").val()) != ''){
                $("#phon").on("input propertychange",function(){
                $(".username img").remove();
                $("#phon").css( "border-bottom","1px solid #10ecdaf6");
                });
               if(regphone.test($("#phon").val())){
                $(".username img").remove();
                $(".username").append(str1);
               }else{
                $(".username img").remove();
                $(".username").append(str2);
               }
               }else{
                $(".username img").remove();
               }
           })

           $("#but").click(function(){
            if($.trim($("#phon").val()) != ''){
               if(regphone.test($("#phon").val())){
                   $("#phon").css( "border-bottom","1px solid #10ecdaf6");
                   alert("验证码已发送，请在1分钟内输入验证码")
               }
               }else if($.trim($("#phon").val()) == ''){
                   $("#phon").css( "border-bottom","1px solid #F50");
                   $(".username img").remove();
               }
           })

        })
    </script>
</head>
<body>
    <div class="all">
    <div class="body">
<%--        <form action="loginServlet" method="post">--%>
        <p id="wel">欢迎回到温暖小窝♪(^∇^*)</p>
        <div class="username">
            手机号 <input type="text" id="phon" autocomplete="off">
        </div>
        <div class="pwd">
            验证码 <input type="text" id="in1" autocomplete="off">
            <input type="button" id="but" value="点击发送验证码">
        </div>
        <div class="footer">
            <div id="msg">
                <span class="error"></span>
            </div>
            <input type="button" id="button1" value="登录">
           <a id="a1" href="bookstore/UserLogin/loginuser.jsp">点我使用账号密码登录</a>
           <a id="a2" href="bookstore/UserRegist/regist.jsp">还未注册？点我注册吧！</a>
        </div>
<%--        </form>--%>
    </div>
    </div>
</body>
</html>