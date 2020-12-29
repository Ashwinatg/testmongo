package com.example.testMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.testMongo.model.Incoming;

@Repository
public interface IncomingRepository extends MongoRepository<Incoming,String> {

}
