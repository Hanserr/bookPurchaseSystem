package com.bookstore.web;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
        protected void page(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            int pageNo = WebUtils.ParesInt(req.getParameter("pageNo"),1);
            int pageSize = WebUtils.ParesInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
            Page<Book>page = bookService.page(pageNo,pageSize);
            page.setUrl("client/clientBookServlet?action=page");
            req.setAttribute("page",page);
            req.getRequestDispatcher("/bookstore/Client/index.jsp").forward(req,resp);
        }
        protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            int pageNo = WebUtils.ParesInt(req.getParameter("pageNo"),1);
            int pageSize = WebUtils.ParesInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
            int min = WebUtils.ParesInt(req.getParameter("min"),0);
            int max = WebUtils.ParesInt(req.getParameter("max"),Integer.MAX_VALUE);
            Page<Book>page = bookService.pageByPrice(pageNo,pageSize,min,max);
            StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
            if(req.getParameter("min")!=null){
                sb.append("&min=").append(req.getParameter("min"));
            }
            if (req.getParameter("max")!=null){
                sb.append("&max=").append(req.getParameter("max"));
            }
            page.setUrl(sb.toString());
            req.setAttribute("page",page);
            req.getRequestDispatcher("/bookstore/Client/index.jsp").forward(req,resp);
        }
}

