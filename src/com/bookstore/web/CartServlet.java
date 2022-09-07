package com.bookstore.web;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.CartItem;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.ParesInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice(),book.getStock());
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
           cart = new Cart();
           req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void DeleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.ParesInt(req.getParameter("id"),0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //根据id删除商品项
            cart.DeleteItem(id);
            //重定向回原来页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //清空购物车
            cart.clear();
            //重定向回原来页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取商品id和数量
        int id = WebUtils.ParesInt(req.getParameter("id"),0);
        int count = WebUtils.ParesInt(req.getParameter("count"),1);
        //获取商品对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断是否为空
        if (cart != null){
            cart.update(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
