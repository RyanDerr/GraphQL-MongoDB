package com.graphqljava.tutorial.bookDetails.Domain;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Author {

    private String id;
    private String firstName;
    private String lastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static List<Author> authors = Arrays.asList(
            new Author("9f9f5237-10ab-4000-8a7e-e9eebfb7e752", "Joanne", "Rowling"),
            new Author("026486b2-aca9-4a67-a81e-d54046091897", "Herman", "Melville"),
            new Author("f06a3c79-8db1-4c2b-b185-f19173dc4972", "Anne", "Rice")
    );

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}
