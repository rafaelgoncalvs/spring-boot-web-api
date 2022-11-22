package com.rg.app.springbootwebapi;

public class AddBookCommand {
    public String name;
    public String authorName;

    public AddBookCommand(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }
}
