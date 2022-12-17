package com.graphqljava.tutorial.bookDetails.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

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

    public Iterable<Book> findBooksByTitle(String title) throws GraphQLException {
        List<Book> books = bookRepository.getBookByTitleIsIgnoreCase(title);

        if(books.isEmpty()) {
            throw new GraphQLException("Could Not Find Books(s) With Title [" + title + "]");
        }
        return books;
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
