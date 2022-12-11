package com.graphqljava.tutorial.bookDetails.mongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("author")
@Data
public class Author {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
}
