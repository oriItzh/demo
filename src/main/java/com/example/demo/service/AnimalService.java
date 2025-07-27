package com.example.demo.service;

import com.example.demo.entity.AdoptedAnimal;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    // private final AnimalRepository adoptedAnimalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
    
    // public AdoptedAnimal adoptAnimal(Animal animal, Person person) {
    //     AdoptedAnimal adoptedAnimal = new AdoptedAnimal(animal, person);
    //     return adoptedAnimalRepository.save(adoptedAnimal);

    // }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.getAnimalById(id.longValue()).get();
    }
}
