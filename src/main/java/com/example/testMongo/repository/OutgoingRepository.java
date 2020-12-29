package com.example.testMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.testMongo.model.Outgoing;

public interface OutgoingRepository extends MongoRepository<Outgoing, String> {

}
