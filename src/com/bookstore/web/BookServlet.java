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
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    int pageNo = WebUtils.ParesInt(req.getParameter("pageNo"),1);
    int pageSize = WebUtils.ParesInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    Page<Book>page = bookService.page(pageNo,pageSize);
    page.setUrl("manager/bookServlet?action=page");
    req.setAttribute("page",page);
    req.getRequestDispatcher("/bookstore/manager/BookManage.jsp").forward(req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookService.addBook(WebUtils.CopyParamToBean(req.getParameterMap(),new Book()));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookService.DeleteBook(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookService.updateBook(WebUtils.CopyParamToBean(req.getParameterMap(),new Book()));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.valueOf(req.getParameter("id"));
        Book book = bookService.queryBookById(i);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/bookstore/manager/updateBook.jsp").forward(req,resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/bookstore/manager/BookManage.jsp").forward(req,resp);
    }
}
