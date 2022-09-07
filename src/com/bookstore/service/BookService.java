package com.bookstore.service;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void DeleteBook(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> page(int pageNo,int pageSize);
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
