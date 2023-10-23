package com.example.mongodblab2.repos;

import com.example.mongodblab2.models.Enclosures;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnclosuresRepository extends MongoRepository<Enclosures, ObjectId> { }
