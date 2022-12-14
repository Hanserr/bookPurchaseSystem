package com.bookstore.dao;

import com.bookstore.pojo.Book;
import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int DeleteBook(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Integer queryForPageTotalCount();
    public List<Book> queryForPageItems(int begin, int pageSize);
    Integer queryForPageTotalCountByPrice(int min, int max);
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
