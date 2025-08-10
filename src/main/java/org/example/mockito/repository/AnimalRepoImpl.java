package org.example.mockito.repository;

import org.example.mockito.model.Animal;

import java.util.List;

public class AnimalRepoImpl implements AnimalRepo{
    @Override
    public void save(Animal animal) {

    }

    @Override
    public Animal findById(Long id) {
        return null;
    }

    @Override
    public List<Animal> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
