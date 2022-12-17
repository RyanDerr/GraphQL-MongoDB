package com.graphqljava.tutorial.bookDetails.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.AuthorRepository;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Optional;

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

    public Author findAuthorById(String id) throws GraphQLException {
        Optional<Author> optionalAuthor =  authorRepository.findById(id);

        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        throw new GraphQLException("Could Not Find Provided Author With Id [" + id + "]");
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(String id) throws GraphQLException {
       Optional<Book> optionalBook = bookRepository.findById(id);

       if(optionalBook.isPresent()) {
           return optionalBook.get();
       }
        throw new GraphQLException("Could Not Find Provided Author With Id [" + id + "]");
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
