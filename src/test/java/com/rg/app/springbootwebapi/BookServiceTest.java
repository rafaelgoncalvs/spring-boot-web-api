package com.rg.app.springbootwebapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    public void beforeEach() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldSaveBook()
    {
        var command = new AddBookCommand("Book A", "Author A");

        bookService.add(command);

        // TODO: Change this to custom mock class to avoid using a framework like Mockito
        var argumentCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save(argumentCaptor.capture());

        assertEquals(argumentCaptor.getValue().getName(), "Book A");
        assertEquals(argumentCaptor.getValue().getAuthorName(), "Author A");
    }
}
