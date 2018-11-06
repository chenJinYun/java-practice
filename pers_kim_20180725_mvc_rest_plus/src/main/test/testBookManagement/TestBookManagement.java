package testBookManagement;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.kim.mvc_rest_plus.dao.BookDao;
import pers.kim.mvc_rest_plus.pojo.Book;
import pers.kim.mvc_rest_plus.service.BookManager;

import java.util.Date;
import java.util.List;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
public class TestBookManagement {
    private static ApplicationContext context;
    private static BookManager bookManager;
    @BeforeClass
    public static void init(){
        context=new ClassPathXmlApplicationContext("classpath:spring/dispatcher-config.xml");
        bookManager=context.getBean(BookManager.class);
    }

    @Test
    public void testAddBook(){
        Book book = new Book(2, "leo", 23.22,new Date(),"kim");
        int m = bookManager.addBookService(book);
        Assert.assertTrue(m > 0);
    }
    @Test
    public void testUpdateBook() {
        Book book = new Book(3, "kim2", 23.22,new Date(),"leo");
        int m = bookManager.updateBookService(book);
        Assert.assertTrue(m > 0);
    }
    @Test
    public void testDeleteBook() {
        int m = bookManager.deleteBookService(3);
        Assert.assertTrue(m > 0);
    }

    @Test
    public void testSelectBook() {
        List<Book> list = bookManager.findAllBookService();
        Assert.assertTrue(list.size() > 0);
    }
}
