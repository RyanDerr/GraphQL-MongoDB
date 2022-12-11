package com.graphqljava.tutorial.bookDetails.Domain;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Book {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    public Book(String id, String name, int pageCount, String authorId) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    private static List<Book> books = Arrays.asList(
          new Book("ab2403bb-6516-4e78-bea4-898d36ce9e58", "Harry Potter and the Philosopher's Stone", 223, "9f9f5237-10ab-4000-8a7e-e9eebfb7e752"),
            new Book("9a338179-73d0-4a42-b6d5-01b146eee900", "Moby Dick", 635, "026486b2-aca9-4a67-a81e-d54046091897"),
            new Book("e80fd0b0-cd15-4f2b-bb2d-f8bf1972d6db", "Interview with the vampire", 371, "f06a3c79-8db1-4c2b-b185-f19173dc4972")
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}
