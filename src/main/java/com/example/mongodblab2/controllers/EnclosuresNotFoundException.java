package com.example.mongodblab2.controllers;

public class EnclosuresNotFoundException extends RuntimeException {
    EnclosuresNotFoundException(String id) {
        super("Could not find review " + id);
    }
}
