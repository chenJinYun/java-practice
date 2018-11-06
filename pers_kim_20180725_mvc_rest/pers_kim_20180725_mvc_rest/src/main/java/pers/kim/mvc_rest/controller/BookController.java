package pers.kim.mvc_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pers.kim.mvc_rest.pojo.Book;

import javax.annotation.Resource;
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
    private List<Book> books;

    @GetMapping
    public List<Book> findAllBooks() {
        return books;
    }

    @PostMapping
    public List<Book> addBook(@RequestBody Book book) {
        String bookId = books.get(books.size() - 1).getId();
        int newId = Integer.parseInt(bookId) + 1;
        book.setId(newId + "");
        books.add(book);
        return books;
    }

    @PutMapping
    public List<Book> updateBookById(@RequestBody Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(book.getId())) {
                books.remove(books.get(i));
                books.add(i, book);
                break;
            }
        }
        return books;
    }

    @DeleteMapping("/{bookId}")
    public List<Book>  deleteBookById(@PathVariable("bookId") String bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(bookId)) {
                books.remove(books.get(i));
                break;
            }
        }
        return books;
    }
}
