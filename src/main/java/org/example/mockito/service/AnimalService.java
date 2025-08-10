package org.example.mockito.service;

// CRUD = create, read, update, delete

import org.example.mockito.model.Animal;

import java.util.List;

public interface AnimalService {

    void save(Animal animal);
    Animal getById(Long id);
    List<Animal> getAllAnimals();
    void deleteById(Long id);
}
