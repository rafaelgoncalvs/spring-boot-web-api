package com.rg.app.springbootwebapi;

import java.util.UUID;

public class BookQuery {
    public UUID id;
    public String name;
    public String authorName;

    public BookQuery(UUID id, String name, String authorName) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
    }
}
