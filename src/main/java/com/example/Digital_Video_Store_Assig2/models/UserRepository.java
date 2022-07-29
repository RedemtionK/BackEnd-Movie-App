package com.example.Digital_Video_Store_Assig2.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    //public UserModel findByUsername(String username);
    UserModel  findByEmail(String email);
}
