package com.graphqljava.tutorial.bookDetails.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.AuthorRepository;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
