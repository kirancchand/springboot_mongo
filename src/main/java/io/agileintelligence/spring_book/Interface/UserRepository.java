package io.agileintelligence.spring_book.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.agileintelligence.spring_book.Model.User;

public interface UserRepository extends MongoRepository<User, String>{


}
