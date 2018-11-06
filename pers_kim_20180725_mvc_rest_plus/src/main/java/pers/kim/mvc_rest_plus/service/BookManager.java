package pers.kim.mvc_rest_plus.service;

import pers.kim.mvc_rest_plus.pojo.Book;

import java.util.List;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
public interface BookManager {
    public int addBookService(Book book);

    public int deleteBookService(int id);

    public int updateBookService(Book book);

    public List<Book> findAllBookService();
}
