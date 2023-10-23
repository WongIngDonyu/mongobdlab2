package com.example.mongodblab2.controllers;

import com.example.mongodblab2.dtos.FeedingsDto;
import com.example.mongodblab2.services.FeedingsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedingsController {
    @Autowired
    private FeedingsService feedingsService;

    @GetMapping("/feedings")
    Iterable<FeedingsDto> allFeedings()
    {
        return feedingsService.getAll();
    }

    @GetMapping("/feedings/{id}")
    FeedingsDto oneFeedings(@PathVariable String id) throws  Throwable {
        return (FeedingsDto) feedingsService.findFeeding(new ObjectId(id))
                .orElseThrow(() -> new FeedingsNotFoundException(id));
    }

    @PostMapping("/feedings")
    FeedingsDto newFeedings(@RequestBody FeedingsDto newFeedings){
            return feedingsService.createFeedings(newFeedings);
        }

    @DeleteMapping("/feedings/{id}")
    void deleteFeedings(@PathVariable String id) {feedingsService.delete(new ObjectId(id));}

    @PostMapping("/feedings/update")
    FeedingsDto updateFeedings(@RequestBody FeedingsDto feedingsDto)
    {  return feedingsService.updateFeedings(feedingsDto); }
}
