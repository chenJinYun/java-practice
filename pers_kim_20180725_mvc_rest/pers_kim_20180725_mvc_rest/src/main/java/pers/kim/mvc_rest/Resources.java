package pers.kim.mvc_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.kim.mvc_rest.pojo.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Create on 7/25/2018
 *
 * @Author Kim
 */
@Component
public class Resources {

    @Bean(name = "books")
    public List<Book> initBookList() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i + "");
            book.setName("kim" + i);
            book.setPrice(i + 1);
            book.setAuthor("kim chen" + i);
            book.setPublishDate(new Date());
            books.add(book);
        }
        return books;
    }
}
