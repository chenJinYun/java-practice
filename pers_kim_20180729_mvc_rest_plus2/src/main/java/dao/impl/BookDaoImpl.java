package dao.impl;

import dao.BookDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pojo.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Create on 7/29/2018
 *
 * @Author Kim
 */
@Repository
public class BookDaoImpl implements BookDao {
    @PersistenceContext(name = "em")
    private EntityManager manager;

    @Override
    public Book addBook(Book book) {
        manager.persist(book);
        return book;
    }

    @Override
    public Book deleteBook(String id) {
        Book book = manager.getReference(Book.class, id);
        manager.remove(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        Book b = manager.getReference(Book.class, book.getId());
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPublishDate(book.getPublishDate());
        return b;
    }

    @Override
    public List<Book> findAllBook() {
        Query query = manager.createQuery("from pojo.Book");
        List resultList = query.getResultList();
        return resultList;
    }
}
