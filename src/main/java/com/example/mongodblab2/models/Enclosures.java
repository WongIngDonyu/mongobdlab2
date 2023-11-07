package com.example.mongodblab2.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "enclosures")
@CompoundIndex(def="{'name':1, 'type':-1}", unique = true, background = false, sparse = false)
public class Enclosures extends BaseEnity{
    @Field(name="enclosuresName")
    @Indexed(unique = true, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String name;
    @Field(name="enclosuresType")
    private String type;
    @Field(name="recommendedFood")
    private String food;
    private Size size;
    private Animal[] animals;
    public static class Size {
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

    public static class Animal {
        private Long id;
        private String name;
        private String species;
        private int age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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
    Enclosures(){}

    public Enclosures(String name, String type, String food, Size size, Animal[] animals) {
        this.name = name;
        this.type = type;
        this.food = food;
        this.size = size;
        this.animals = animals;
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

}
