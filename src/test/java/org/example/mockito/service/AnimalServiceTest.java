package org.example.mockito.service;

import org.example.mockito.model.Animal;
import org.example.mockito.repository.AnimalRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/* Lipiciul dintre JUnit 4 si Mockito JUnit
* initializeaza anotatiile de mocking -> @Mock, @InjectMocks
* @Mock creeaza o copie FALSA a layerului mockuit din aplicatia MVC -> repository-ul care se conecteaza la DB
* */
@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    private AnimalRepo animalRepo;

    @InjectMocks
    private AnimalServiceImpl animalService;

    @Test
    void test_saveAnimal() {
        Animal animal = new Animal("Lion", "Mammal");

        animalService.save(animal);

        verify(animalRepo, times(1)).save(animal);
        verifyNoMoreInteractions(animalRepo);
    }

    @Test
    void test_getAnimalById() {
        Animal animal = new Animal("Elephant", "Mammal");
        when(animalRepo.findById(1L))
                .thenReturn(animal);

        Animal result = animalService.getById(1L);

        assertThat(result)
                .isNotNull()
                .isEqualTo(animal);
        verify(animalRepo, times(1)).findById(1L);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 33L})
    void test_deleteById(long id) {
        animalService.deleteById(id);

        verify(animalRepo, times(1)).deleteById(id);
    }
}