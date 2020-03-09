package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;

import java.util.List;

public interface retrieveDog {
    List<String> retrieveDogByBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
    List<Dog> retrieveDogs();
}

