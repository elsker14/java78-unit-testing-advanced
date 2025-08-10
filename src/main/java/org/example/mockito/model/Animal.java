package org.example.mockito.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // getters, setters, equals, hashcode, tostring
@NoArgsConstructor  // constructor neparametrizat
public class Animal {

    private Long id;
    private String name;
    private String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }
}
