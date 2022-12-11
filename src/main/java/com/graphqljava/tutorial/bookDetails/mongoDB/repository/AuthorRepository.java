package com.graphqljava.tutorial.bookDetails.mongoDB.repository;

import com.graphqljava.tutorial.bookDetails.mongoDB.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
