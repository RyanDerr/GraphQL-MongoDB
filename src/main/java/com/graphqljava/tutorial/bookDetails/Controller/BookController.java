package com.graphqljava.tutorial.bookDetails.Controller;

import com.graphqljava.tutorial.bookDetails.Domain.Author;
import com.graphqljava.tutorial.bookDetails.Domain.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        //In Many Cases This Would Call A Java Service To Retrieve A Book Object From A DB
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        //In Many Cases This Would Call A Java Service To Retrieve A Book Object From A DB
        return Author.getById(book.getAuthorId());
    }
}
