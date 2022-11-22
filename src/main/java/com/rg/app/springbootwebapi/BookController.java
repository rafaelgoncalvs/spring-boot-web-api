package com.rg.app.springbootwebapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookQuery> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public BookQuery get(@PathVariable UUID id) {
        return bookService.get(id);
    }

    @PostMapping("add")
    public Object add(@RequestBody AddBookCommand addBookCommand) {
        return bookService.add(addBookCommand);
    }
}
