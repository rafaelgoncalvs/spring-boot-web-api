package com.rg.app.springbootwebapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Application
{
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book(UUID.randomUUID(), "Book A", "Author A"));
            repository.save(new Book(UUID.randomUUID(), "Book B", "Author A"));
            repository.save(new Book(UUID.randomUUID(), "Book C", "Author A"));
            repository.save(new Book(UUID.randomUUID(), "Book D", "Author B"));
            repository.save(new Book(UUID.randomUUID(), "Book E", "Author B"));
            repository.save(new Book(UUID.randomUUID(), "Book F", "Author C"));
        };
    }

}
