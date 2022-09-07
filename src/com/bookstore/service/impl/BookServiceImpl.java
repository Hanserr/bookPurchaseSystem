package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import com.bookstore.service.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
    bookDao.addBook(book);
    }
    @Override
    public void DeleteBook(Integer id) {
    bookDao.DeleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
    bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo,int pageSize) {
        Page<Book>page = new Page<Book>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页最大数量
        page.setPageSize(pageSize);
        //总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        page.setPageTotal((int)Math.ceil((double)Integer.valueOf(pageTotalCount)/(double) pageSize));
        //
        int begin = (page.getPageNo()-1)*pageSize;
        List<Book>items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book>page = new Page<Book>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页最大数量
        page.setPageSize(pageSize);
        //总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        page.setPageTotal((int)Math.ceil((double)Integer.valueOf(pageTotalCount)/(double) pageSize));
        //
        int begin = (page.getPageNo()-1)*pageSize;
        List<Book>items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
