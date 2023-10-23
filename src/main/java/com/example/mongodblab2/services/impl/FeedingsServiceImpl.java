package com.example.mongodblab2.services.impl;

import com.example.mongodblab2.dtos.FeedingsDto;
import com.example.mongodblab2.models.Feedings;
import com.example.mongodblab2.repos.FeedingsRepository;
import com.example.mongodblab2.services.FeedingsService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedingsServiceImpl implements FeedingsService {
    private final FeedingsRepository feedingsRepository;
    private final ModelMapper  modelMapper;
    public FeedingsServiceImpl(FeedingsRepository feedingsRepository, ModelMapper modelMapper){
        this.feedingsRepository = feedingsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FeedingsDto createFeedings(FeedingsDto feedings) {
        Feedings feedings1 = modelMapper.map(feedings, Feedings.class);
        return modelMapper.map(feedingsRepository.save(feedings1), FeedingsDto.class);
    }

    @Override
    public void delete(FeedingsDto feedingsDto) {
        feedingsRepository.deleteById(feedingsDto.getId());
    }

    @Override
    public void delete(ObjectId id) {
        feedingsRepository.deleteById(id);
    }

    @Override
    public List<FeedingsDto> getAll() {
        return feedingsRepository.findAll().stream().map((b) -> modelMapper.map(b, FeedingsDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<FeedingsDto> findFeeding(ObjectId id) {
        return Optional.ofNullable(modelMapper.map(feedingsRepository.findById(id), FeedingsDto.class));
    }

    @Override
    public FeedingsDto updateFeedings(FeedingsDto feedingsDto) {
        Optional<Feedings> dbFeedings = feedingsRepository.findById(feedingsDto.getId());
        if (dbFeedings.isEmpty()){
            throw new NoSuchElementException("Error id");
        }
        Feedings feedings = modelMapper.map(feedingsDto, Feedings.class);
        return modelMapper.map(feedingsRepository.save(feedings), FeedingsDto.class);
    }
}
