package com.bookstore.web;

import com.bookstore.service.ManagerService;
import com.bookstore.service.impl.ManagerServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerLogin extends BaseServlet{
    private ManagerService managerService = new ManagerServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String password = req.getParameter("password");
    if((managerService.login(name,password))!= null){
        req.getRequestDispatcher("/bookstore/manager/WelcomeMa.jsp").forward(req,resp);
    }else{
        req.setAttribute("msg","用户名或密码错误!");
        req.getRequestDispatcher("/bookstore/manager/ManagerLogin.jsp").forward(req,resp);
    }
    }
}




