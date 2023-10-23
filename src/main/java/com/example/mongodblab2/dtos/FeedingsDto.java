package com.example.mongodblab2.dtos;

import com.example.mongodblab2.utils.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class FeedingsDto {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private LocalDate date;
    private String food;
    private int quantity;
    public FeedingsDto(){}

    public FeedingsDto(ObjectId id, LocalDate date, String food, int quantity) {
        this.id = id;
        this.date = date;
        this.food = food;
        this.quantity = quantity;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
