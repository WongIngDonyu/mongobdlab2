package com.example.mongodblab2.services.impl;

import com.example.mongodblab2.dtos.EnclosureFeedingsDto;
import com.example.mongodblab2.dtos.EnclosuresDto;
import com.example.mongodblab2.models.Enclosures;
import com.example.mongodblab2.repos.EnclosuresRepository;
import com.example.mongodblab2.services.EnclosuresService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service

public class EnclosuresServiceImpl implements EnclosuresService {
    private final EnclosuresRepository enclosuresRepository;
    private final ModelMapper modelMapper;
    private final MongoTemplate mongoTemplate;

    public EnclosuresServiceImpl(EnclosuresRepository enclosuresRepository, ModelMapper modelMapper, MongoTemplate mongoTemplate){
        this.enclosuresRepository = enclosuresRepository;
        this.modelMapper = modelMapper;
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public EnclosuresDto createEnclosures(EnclosuresDto enclosuresDto) {
        Enclosures enclosures = modelMapper.map(enclosuresDto, Enclosures.class);
        return modelMapper.map(enclosuresRepository.save(enclosures), EnclosuresDto.class);
    }

    @Override
    public void delete(EnclosuresDto enclosuresDto) {
        enclosuresRepository.deleteById(enclosuresDto.getId());
    }

    @Override
    public void delete(ObjectId id) {
        enclosuresRepository.deleteById(id);
    }

    @Override
    public List<EnclosuresDto> getAll() {
        return enclosuresRepository.findAll().stream().map((b) -> modelMapper.map(b, EnclosuresDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<EnclosuresDto> findEnclosure(ObjectId id) {
        return Optional.ofNullable(modelMapper.map(enclosuresRepository.findById(id), EnclosuresDto.class));
    }

    @Override
    public EnclosuresDto updateEnclosures(EnclosuresDto enclosuresDto) {
        Optional<Enclosures> dbEnclosures = enclosuresRepository.findById(enclosuresDto.getId());
        if (dbEnclosures.isEmpty()){
            throw new NoSuchElementException("Error id");
        }
        Enclosures enclosures = modelMapper.map(enclosuresDto, Enclosures.class);
        return modelMapper.map(enclosuresRepository.save(enclosures), EnclosuresDto.class);
    }

    @Override
    public List<EnclosureFeedingsDto> findEnclosuresWithHighQuantityFood() {//вывод общего кол-во кормлений каждого вальера по их типу питания и сортировка по возрастанию
        Aggregation aggregation = Aggregation.newAggregation(
                lookup("feedings", "recommendedFood", "foodType", "feedings"),
                unwind("feedings"),
                group("enclosuresName")
                        .sum("feedings.quantity").as("totalFeedings"),
                project()
                        .andExpression("_id").as("enclosureName")
                        .andExpression("totalFeedings").as("totalFeedings"),
                sort(Sort.Direction.ASC, "totalFeedings")
        );
        AggregationResults<EnclosureFeedingsDto> results = mongoTemplate.aggregate(aggregation, "enclosures", EnclosureFeedingsDto.class);
        return results.getMappedResults();
    }
}
