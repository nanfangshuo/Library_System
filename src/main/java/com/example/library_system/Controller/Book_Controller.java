package com.example.library_system.Controller;

import com.example.library_system.Entity.Book;
import com.example.library_system.Service.Book_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/books")
public class Book_Controller {
    @Autowired
    private Book_Service bookService;

    @GetMapping("/{id}")
    // getBookById方法，该方法接受一个Long类型的id参数，并返回一个Book对象。
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    // createBook方法，该方法创建一个Book对象，并返回一个Book对象。
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    // updateBook方法，该方法接受一个Long类型的id参数和一个Book对象，并返回一个Book对象。
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    // deleteBook方法，该方法接受一个Long类型的id参数，没有返回值。
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/list")
    // getAllBooks方法，该方法接受两个int类型的参数page和size，并返回一个Page<Book>对象。
    public Page<Book> getAllBooks(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return bookService.findAll(PageRequest.of(page, size));
    }
}
