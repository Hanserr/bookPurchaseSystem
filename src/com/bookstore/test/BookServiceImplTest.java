package com.bookstore.test;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {
private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"ygyg","err",new BigDecimal(12312),123,123,null));
    }

    @Test
    public void deleteBook() {
    bookService.DeleteBook(5);
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1,5));
        System.out.println((int)Math.ceil((double)6/(double)5));
    }
}