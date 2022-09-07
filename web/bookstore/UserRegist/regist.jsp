<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
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
    <title>注册(๑•̀ㅂ•́)و✧</title>
    <link rel="stylesheet" href="bookstore/UserRegist/regist.css" type="text/css">
    <script src="bookstore/jquery-3.5.1.js"></script>
    <script>
        $(function(){
           var num = 0;
           var regname = /^[\u4e00-\u9fa5a-zA-Z0-9_]{4,8}$/;
           var regphone = /^1[345678]\d{9}$/;
           var regemail = /^([a-zA-Z0-9-._])+\@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
           var str1 = " <img class='str' src='bookstore/UserRegist/right.png' style='width: 15px;height: 15px;vertical-align: middle;'>";
           var str2 = " <img class='str' src='bookstore/UserRegist/wrong.png' style='width: 15px;height: 15px;vertical-align: middle;'>";

           //用户名输入框失焦事件
           $("#usern").blur(function(){
               if($.trim($("#usern").val()) != ''){
                if(regname.test($("#usern").val())){
                $(".username img").remove();
                $(".username").append(str1);
               }else{
                $(".username img").remove();
                $(".username").append(str2);
               }
               }
           })
           $("#kap").click(function(){
               this.src = "${basePath}kaptcha.jpg?d="+new Date();
           })
           //手机号输入框失焦事件
           $("#phon").blur(function(){
               if($.trim($("#phon").val()) != ''){
                $("#phon").on("input propertychange",function(){
                $(".phone img").remove();
                $("#phon").css( "border-bottom","1px solid #10ecdaf6");
                });   
               if(regphone.test($("#phon").val())){
                $(".phone img").remove();
                $(".phone").append(str1);
               }else{
                $(".phone img").remove();
                $(".phone").append(str2);
               }
               }else{
                $(".phone img").remove();
               }
           })

           //密码可见与不可见
           $(".pwd1 img").click(function(){
            if($(".pwd1 input").attr("type") == "password"){
                $(".pwd1 input").attr("type","text");
                $(".pwd1 img").attr("src","bookstore/UserRegist/close.png");
            }else if($(".pwd1 input").attr("type") == "text"){
                $(".pwd1 input").attr("type","password");
                $(".pwd1 img").attr("src","bookstore/UserRegist/open.png");
            }
           })
           //邮箱输入框失焦事件
           $("#ema").blur(function(){
               if(($("#ema").val()) != ""){
               if(regemail.test($.trim($("#ema").val()))){
                $(".em img").remove();
                $(".em").append(str1);
               }else{
                $(".em img").remove();
                $(".em").append(str2);
               }
               }
           })

           //验证码发送按钮及弹窗
           $("#button2").click(function(){
            if($.trim($("#phon").val()) != ''){
               if(regphone.test($("#phon").val())){
                alert("验证码已发送，请在1分钟内输入验证码");
                return false;
               }
               }else if($.trim($("#phon").val()) == ''){
                   $("#phon").css( "border-bottom","1px solid #F50");
                   $(".phone img").remove();
               }
           })

           //注册按钮及检查操作
           $("#button1").click(function(){
               if(!$("#rad").prop("checked")){
                   alert("请阅读并接受用户协议")
                   return false;
               }else if($("#rad").prop("checked")){
                   if(
                   $.trim($("#usern").val()) != "" && 
                   $.trim($("#phon").val()) != "" && 
                   $.trim($(".pwd1 input").val()) != "" && 
                   $.trim($(".pwd2 input").val()) != "" &&
                   $.trim($(".num input").val()) != "" &&
                   regname.test($("#usern").val()) &&
                   regphone.test($("#phon").val()) &&
                   $(".pwd1 input").val().length>=8 &&
                   $(".pwd1 input").val() == $(".pwd2 input").val() &&
                   $(".num input").val().length == 6
                   ){
                   }else{
                    alert("请检查是否输错！")
                       return false;
                   }
               }
           })
        })
    </script>
</head>
<body>
    <div class="all">
    <div class="body">
        <p>欢迎注册呀</p>
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="regist" name="id">
        <div class="username">
            *用户名 <input type="text" id="usern" name="username" placeholder="长度4-8位，只允许使用中英文 下划线 数字"
                        autocomplete="off" value="${requestScope.username}">
        </div>
        <div class="phone">
            *手机号 <input type="text" id="phon" name="phone" placeholder="可用于登录和找回密码" autocomplete="off"
                        value="${requestScope.phone}">
        </div>
        <div class="pwd1">
            *密码 <input type="password" name="password" placeholder="请设置登录密码 限制8-16个字符 !  !" autocomplete="off" maxlength="16"
                       value="${requestScope.password}">
            <img id="open" src="bookstore/UserRegist/open.png" style="width: 25px;height: 25px;vertical-align: middle;">
        </div>
        <div class="pwd2">
            *密码 <input type="password" name="password2" placeholder="请再次输入密码" autocomplete="off" maxlength="16"
                       value="${requestScope.password}">
        </div>
        <div class="em">
            邮箱 <input type="text" id="ema" name="email" placeholder="请输入电子邮箱地址" autocomplete="off"
                      value="${requestScope.email}">
        </div>
        <div class="num">
           *验证码 <input type="text" name="code" placeholder="请输入手机验证码" autocomplete="off" maxlength="6">
        </div>
        <div class="pic">
            *验证码 <input type="text" name="token" placeholder=${requestScope.msg?requestScope.msg:"请输入图形验证码"} autocomplete="off" maxlength="5">
            <img src="kaptcha.jpg" id="kap">
        </div>
        <div class="footer">
           <div>
            <input type="submit" id="button1" value="注册">
           </div>
           <div>
            <input type="button" id="button2" value="点击获取验证码">
           </div>
        </div>
        </form>
        <div class="agreement">
        <input type="checkbox" id="rad"> 阅读并接受 <a href="bookstore/UserRegist/agree.html" target="blank" id="lable1">《用户协议》</a>及<a href="bookstore/UserRegist/statement.html" target="blank" id="lable2">《隐私权保护声明》</a>
        </div>
    </div>
    </div>
</body>
</html>