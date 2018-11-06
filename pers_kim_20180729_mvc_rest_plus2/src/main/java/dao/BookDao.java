package dao;

import pojo.Book;

import java.util.List;

/**
 * Create on 7/29/2018
 *
 * @Author Kim
 */
public interface BookDao {
    public Book addBook(Book book);

    public Book deleteBook(String id);

    public Book updateBook(Book book);

    public List<Book> findAllBook();
}
