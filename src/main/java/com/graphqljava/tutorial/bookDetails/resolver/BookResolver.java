package com.graphqljava.tutorial.bookDetails.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorRepository authorRepository;

    public BookResolver (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthorId()).orElseThrow(null);
    }
}
