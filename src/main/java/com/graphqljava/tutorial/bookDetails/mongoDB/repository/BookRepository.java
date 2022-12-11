package com.graphqljava.tutorial.bookDetails.mongoDB.repository;

import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
