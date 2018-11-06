package pers.kim.mvc_rest_plus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import pers.kim.mvc_rest_plus.dao.BookDao;
import pers.kim.mvc_rest_plus.pojo.Book;

import java.util.List;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
@Component
public class BookManageService implements BookManager {
    @Autowired
    private BookDao bookDao;
    @Override
    public int addBookService(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookService(int id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBookService(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public List<Book> findAllBookService() {
        return bookDao.findAllBook();
    }
}
