package com.example.mongodblab2.controllers;

public class FeedingsNotFoundException extends RuntimeException{
    FeedingsNotFoundException(String id) {
        super("Could not find client " + id);
    }
}
