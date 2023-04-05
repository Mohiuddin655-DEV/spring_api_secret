package com.example.spring_api_secret.repository;

import com.example.spring_api_secret.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<User, String> {

}
