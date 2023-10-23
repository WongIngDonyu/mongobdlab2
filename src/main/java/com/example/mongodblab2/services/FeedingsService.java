package com.example.mongodblab2.services;

import com.example.mongodblab2.dtos.FeedingsDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface FeedingsService {
    FeedingsDto createFeedings(FeedingsDto feedings);
    void delete(FeedingsDto feedingsDto);
    void delete(ObjectId id);
    List<FeedingsDto> getAll();
    Optional<FeedingsDto> findFeeding(ObjectId id);
    FeedingsDto updateFeedings(FeedingsDto feedingsDto);
}
