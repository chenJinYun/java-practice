package testBooks;

import dao.impl.BookDaoImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Book;
import service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Create on 7/29/2018
 *
 * @Author Kim
 */
public class TestBook {
    private static ApplicationContext context;
    private static BookService bookService;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        bookService = context.getBean(BookService.class);
    }

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setName("kim");
        Book b =bookService.addBook(book);
        Assert.assertTrue(b!=null);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setId("8a5e9d4164e5a52a0164e5a52e620000");
        book.setName("asdas");
        Book b=bookService.updateBook(book);
        Assert.assertTrue(b!=null);
    }

    @Test
    public void testDeleteBook() {
        Book b=bookService.deleteBook("8a5e9d4164e5a52a0164e5a52e620000");
        Assert.assertTrue(b!=null);
    }

    @Test
    public void testFindAllBook(){
        List<Book> allBook = bookService.findAllBook();
        Assert.assertTrue(allBook.size()!=0);
    }
}
