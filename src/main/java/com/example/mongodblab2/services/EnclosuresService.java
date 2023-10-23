package com.example.mongodblab2.services;

import com.example.mongodblab2.dtos.EnclosureFeedingsDto;
import com.example.mongodblab2.dtos.EnclosuresDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface EnclosuresService {
    EnclosuresDto createEnclosures(EnclosuresDto enclosuresDto);
    void delete(EnclosuresDto enclosuresDto);
    void delete(ObjectId id);
    List<EnclosuresDto> getAll();
    Optional<EnclosuresDto> findEnclosure(ObjectId id);
    EnclosuresDto updateEnclosures(EnclosuresDto enclosuresDto);
    List<EnclosureFeedingsDto> findEnclosuresWithHighQuantityFood();
}
