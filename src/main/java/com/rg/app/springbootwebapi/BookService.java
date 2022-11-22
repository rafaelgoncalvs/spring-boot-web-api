package com.rg.app.springbootwebapi;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public CommandResponse add(AddBookCommand addBookCommand) {
        var entity = new Book(UUID.randomUUID(), addBookCommand.name, addBookCommand.authorName);
        bookRepository.save(entity);
        return new CommandResponse(entity.getId());
    }

    public List<BookQuery> getAll() {
        return StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .map(book -> new BookQuery(book.getId(), book.getName(), book.getAuthorName()))
                .collect(Collectors.toList());
    }

    public BookQuery get(UUID id) {
        System.out.println("Id: " + id.toString());
        var entity = bookRepository.findById(id);
        if (!entity.isPresent()) {
            throw new RuntimeException("Entity not found.");
        }
        var book = entity.get();
        return new BookQuery(book.getId(), book.getName(), book.getAuthorName());
    }
}
