package com.bookstore.test;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoTest {
private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"ttt","err",new BigDecimal(12312),123,123,null));
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBook() {
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(0, Page.PAGE_SIZE));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book book:bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)){
        System.out.println(book);
        }
    }








}
