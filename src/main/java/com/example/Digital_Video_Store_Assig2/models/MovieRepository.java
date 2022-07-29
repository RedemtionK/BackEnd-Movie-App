package com.example.Digital_Video_Store_Assig2.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<MovieModel,String> {
}
