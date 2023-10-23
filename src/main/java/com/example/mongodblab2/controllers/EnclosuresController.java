package com.example.mongodblab2.controllers;

import com.example.mongodblab2.dtos.EnclosureFeedingsDto;
import com.example.mongodblab2.dtos.EnclosuresDto;
import com.example.mongodblab2.services.EnclosuresService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnclosuresController {
    @Autowired
    private EnclosuresService enclosuresService;

    @GetMapping("/enclosures")
    Iterable<EnclosuresDto> all() {
        return enclosuresService.getAll();
    }

    @PostMapping("/enclosures")
    EnclosuresDto newEnclosure(@RequestBody EnclosuresDto enclosuresDto)
    {  return enclosuresService.createEnclosures(enclosuresDto); }

    @GetMapping("/enclosures/{id}")
    EnclosuresDto oneEnclosure(@PathVariable String id) throws Throwable {
        return (EnclosuresDto) enclosuresService.findEnclosure(new ObjectId(id))
                .orElseThrow(() -> new EnclosuresNotFoundException(id));
    }

    @DeleteMapping("/enclosures/{id}")
    void deleteEnclosures(@PathVariable String id) {
        enclosuresService.delete(new ObjectId(id));

    }

    @PostMapping("/enclosures/update")
    EnclosuresDto updateEnclosure(@RequestBody EnclosuresDto enclosuresDto)
    {  return enclosuresService.updateEnclosures(enclosuresDto); }

    @GetMapping("/enclosures/agrigate")
    List<EnclosureFeedingsDto> getEnclosuresWithHighQuantityFood(){
        List<EnclosureFeedingsDto> results = enclosuresService.findEnclosuresWithHighQuantityFood();
        return results;
    }
}
