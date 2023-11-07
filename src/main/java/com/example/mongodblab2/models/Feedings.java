package com.example.mongodblab2.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "feedings")
@CompoundIndex(def="{'food':1, 'quantity':-1}", unique = true, background = false, sparse = false)
public class Feedings extends BaseEnity{
    @Field(name="feedingDate")
    @Indexed(unique = true, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private LocalDate date;
    @Field(name="foodType")
    private String food;
    @Field(name="quantity")
    private int quantity;
    public Feedings(){}

    public Feedings(LocalDate date, String food, int quantity) {
        this.date = date;
        this.food = food;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Feedings{" +
                "date=" + date +
                ", food='" + food + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
