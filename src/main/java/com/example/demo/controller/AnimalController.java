package com.example.demo.controller;

import com.example.demo.entity.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal Animal) {
        Animal newAnimal = animalService.saveAnimal(Animal);
        logger.info("added Animal: {}", newAnimal);
        return newAnimal;
    }

    @PostMapping("/batch")
    public List<Animal> addAnimals(@RequestBody List<Animal> animals) {
        List<Animal> newAnimals = new ArrayList<Animal>();

        for (Animal animal : animals) {
            Animal newAnimal = animalService.saveAnimal(animal);
            logger.info("added Animal: {}", newAnimal);
            newAnimals.add(newAnimal);
        }
        return newAnimals;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @DeleteMapping
    public void deleteAnimal(@RequestParam("id") Long id) {
        Animal AnimalToDel = animalService.getAnimalById(id);
        logger.info("deleting Animal: {}... with name {}", id, AnimalToDel.getName());
        animalService.deleteAnimal(id);
        logger.info("deleted Animal: {}", id);
    }
}
