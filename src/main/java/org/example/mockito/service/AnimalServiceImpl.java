package org.example.mockito.service;

import lombok.AllArgsConstructor;
import org.example.mockito.model.Animal;
import org.example.mockito.repository.AnimalRepo;

import java.util.List;

// business logic + DTO <-> DAO mapping

@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepo repo;

    @Override
    public void save(Animal animal) {
        this.repo.save(animal);
    }

    @Override
    public Animal getById(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return this.repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.repo.deleteById(id);
    }
}
