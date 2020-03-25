package io.agileintelligence.spring_book.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.spring_book.Model.AuthorBookModel;
@Repository
public interface AuthorBookInterface extends MongoRepository<AuthorBookModel, Integer>{

}
