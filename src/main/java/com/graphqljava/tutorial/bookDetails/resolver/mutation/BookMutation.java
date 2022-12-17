package com.graphqljava.tutorial.bookDetails.resolver.mutation;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.BookRepository;
import graphql.GraphQLException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(String title, String description, String authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthorId(authorId);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(String id) {
        bookRepository.deleteById(id);

        return true;
    }

    public Book updateBook(String id, String title, String description) throws GraphQLException {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            if (!StringUtils.isEmpty(title)) {
                book.setTitle(title);
            }
            if (!StringUtils.isEmpty(description)) {
                book.setDescription(description);
            }

            bookRepository.save(book);

            return book;
        }

        throw new GraphQLException("Could Not Find Provided Book To Update!");
    }
}
