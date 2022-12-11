package com.graphqljava.tutorial.bookDetails.mongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
@Data
public class Book {

    @Id
    private String id;
    private String title;
    private String description;
    private String authorId;
}
