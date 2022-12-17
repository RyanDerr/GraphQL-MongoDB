package com.graphqljava.tutorial.bookDetails.resolver;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.AuthorRepository;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.BookRepository;
import graphql.GraphQLException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String firstName, String lastName, int age) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

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
