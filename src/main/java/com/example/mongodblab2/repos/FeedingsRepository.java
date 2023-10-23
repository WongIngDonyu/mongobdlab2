package com.example.mongodblab2.repos;
import com.example.mongodblab2.models.Feedings;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingsRepository extends MongoRepository<Feedings, ObjectId> {
}
