package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Book;
import service.BookService;

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
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findAllBooks() {
        return bookService.findAllBook();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Book updateBookById(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public Book deleteBookById(@PathVariable("bookId") String bookId) {
        return bookService.deleteBook(bookId);
    }
}
