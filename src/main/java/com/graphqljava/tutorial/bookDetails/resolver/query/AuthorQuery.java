package com.graphqljava.tutorial.bookDetails.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import com.graphqljava.tutorial.bookDetails.mongoDB.repository.AuthorRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorQuery implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

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

    public Iterable<Author> findAuthorsByLastName(String lastName) throws GraphQLException {
        List<Author> authors = authorRepository.getAuthorByLastNameIsIgnoreCase(lastName);

        if(authors.isEmpty()) {
            throw new GraphQLException("Could Not Find Author(s) With Name [" + lastName + "]");
        }
        return authors;
    }

    public long countAuthors() {
        return authorRepository.count();
    }

}
