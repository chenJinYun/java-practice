package service;

import pojo.Book;

import java.util.List;

/**
 * Create on 7/29/2018
 *
 * @Author Kim
 */
public interface BookService {
    public Book addBook(Book book);

    public Book deleteBook(String id);

    public Book updateBook(Book book);

    public List<Book> findAllBook();
}
