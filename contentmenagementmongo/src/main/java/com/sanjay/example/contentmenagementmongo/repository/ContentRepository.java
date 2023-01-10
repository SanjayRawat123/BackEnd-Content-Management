package com.sanjay.example.contentmenagementmongo.repository;


import com.sanjay.example.contentmenagementmongo.model.Content;
import com.sanjay.example.contentmenagementmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<User,String> {

}
