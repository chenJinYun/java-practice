package pers.kim.mvc_rest_plus.dao;


import pers.kim.mvc_rest_plus.pojo.Book;

import java.util.List;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBook(int id);

    public int updateBook(Book book);

    public List<Book> findAllBook();
}
