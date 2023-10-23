package com.example.mongodblab2.dtos;

public class EnclosureFeedingsDto {
    private String enclosureName;
    private int totalFeedings;

    public String getEnclosureName() {
        return enclosureName;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }

    public int getTotalFeedings() {
        return totalFeedings;
    }

    public void setTotalFeedings(int totalFeedings) {
        this.totalFeedings = totalFeedings;
    }
}
