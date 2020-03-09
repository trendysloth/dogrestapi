package com.udacity.DogRestApi.controller;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.service.retrieveDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private retrieveDog dogService;

    @Autowired
    public void setLocationService(retrieveDog dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogbreeds")
    public ResponseEntity<List<String>> retrieveDogByBreed() {
        List<String> list = dogService.retrieveDogByBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dognames")
    public ResponseEntity<List<String>> retrieveDogByName() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogbreeds/{id}")
    @ResponseBody
    public ResponseEntity<String> retrieveDogBreedById(@PathVariable Long id) {
        String dogBreed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dogBreed, HttpStatus.OK);
    }

}