package service.impl;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Book;
import service.BookService;

import java.util.List;

/**
 * Create on 7/29/2018
 *
 * @Author Kim
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Transactional
    @Override
    public Book deleteBook(String id) {
        return bookDao.deleteBook(id);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }
}
