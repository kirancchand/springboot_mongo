package io.agileintelligence.spring_book.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.spring_book.Model.AuthorModel;


@Repository
public interface AuthorInterface extends MongoRepository<AuthorModel, Integer> {
	
}