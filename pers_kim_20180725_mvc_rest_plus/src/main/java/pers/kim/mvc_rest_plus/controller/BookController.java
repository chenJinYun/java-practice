package pers.kim.mvc_rest_plus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.kim.mvc_rest_plus.pojo.Book;
import pers.kim.mvc_rest_plus.service.BookManager;

import java.util.List;

/**
 * Create on 7/25/2018
 *
 * @Author Kim
 */

@RequestMapping("books")
@RestController
public class BookController {
    @Autowired
    private BookManager bookManager;
    @GetMapping
    public List<Book> findAllBooks() {
        return bookManager.findAllBookService();
    }

    @PostMapping
    public int addBook(@RequestBody Book book) {
        return bookManager.addBookService(book);
    }

    @PutMapping
    public int updateBookById(@RequestBody Book book) {
        return bookManager.updateBookService(book);
    }

    @DeleteMapping("/{bookId}")
    public int deleteBookById(@PathVariable("bookId") int bookId) {
        return bookManager.deleteBookService(bookId);
    }
}
