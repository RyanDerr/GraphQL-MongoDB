package com.graphqljava.tutorial.bookDetails.mongoDB.repository;

import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> getBookByTitleIsIgnoreCase(String title);
}
