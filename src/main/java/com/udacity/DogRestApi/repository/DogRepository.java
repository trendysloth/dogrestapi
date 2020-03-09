package com.udacity.DogRestApi.repository;
import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    public static final String FIND_DOG_BREEDS = "SELECT breed FROM dog";
    @Query(value = FIND_DOG_BREEDS, nativeQuery = true)
    public List<String> findDogBreeds();

    public static final String FIND_DOG_NAMES = "SELECT name FROM dog";
    @Query(value = FIND_DOG_NAMES, nativeQuery = true)
    public List<String> findDogNames();

    public static final String FIND_DOG_BREEDS_BY_ID = "SELECT breed FROM dog WHERE id = :id";
    @Query(value = FIND_DOG_BREEDS_BY_ID, nativeQuery = true)
    public String findDogBreedById(Long id);
}
