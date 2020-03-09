package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class retrieveDogImpl implements retrieveDog {
    @Autowired
    DogRepository dogRepository;

    public List<String> retrieveDogByBreed() {
        return (List<String>) dogRepository.findDogBreeds();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }


    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findDogNames();
    }

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }
}
