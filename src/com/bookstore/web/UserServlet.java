package com.bookstore.web;

import com.bookstore.pojo.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;
import com.bookstore.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{
    private UserService userService= new UserServiceImpl();
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.CopyParamToBean(req.getParameterMap(),new User());
        String username = user.getUsername();
        String phone = user.getPhone();
        String password = user.getPassword();
        String email = user.getEmail();
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("token");
        if (token.equals(code)){
            if (userService.existsUsername(username)){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("phone",phone);
                req.setAttribute("password",password);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/bookstore/UserRegist/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,phone,password,email));
                req.getRequestDispatcher("/bookstore/UserRegist/registSuccess.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("phone",phone);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/bookstore/UserRegist/regist.jsp").forward(req,resp);
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
             user = WebUtils.CopyParamToBean(req.getParameterMap(),new User());
        } catch (Exception e) {
            e.printStackTrace();
        }
            String username = user.getUsername();
            String password = user.getPassword();
            User user1 = userService.login(new User(null,username,null,password,null));
            if (user1 == null){
                req.setAttribute("msg","用户名或密码错误!");
                req.setAttribute("username",username);
                req.getRequestDispatcher("/bookstore/UserLogin/loginuser.jsp").forward(req,resp);
            }else{
                req.getSession().setAttribute("user",user1);
                req.getRequestDispatcher("/bookstore/UserLogin/loginSuccess.jsp").forward(req,resp);
            }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();
        //重定向
        resp.sendRedirect(req.getContextPath());
    }
}
