package com.example.mongodblab2.dtos;

import com.example.mongodblab2.utils.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;

public class EnclosuresDto {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String name;
    private String type;
    private String food;
    private SizeDto size;
    private AnimalDto[] animals;

    public static class SizeDto {
        private int area;
        private int volume;

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }
    }

    public static class AnimalDto {
        private ObjectId id;
        private String name;
        private String species;
        private int age;

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    EnclosuresDto(){}

    public EnclosuresDto(ObjectId id, String name, String type, String food, SizeDto size, AnimalDto[] animals) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.food = food;
        this.size = size;
        this.animals = animals;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public SizeDto getSize() {
        return size;
    }

    public void setSize(SizeDto size) {
        this.size = size;
    }

    public AnimalDto[] getAnimals() {
        return animals;
    }

    public void setAnimals(AnimalDto[] animals) {
        this.animals = animals;
    }
}
