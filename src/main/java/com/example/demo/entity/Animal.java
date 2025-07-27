package com.example.demo.entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Animal {

    public enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;

    @Override
    public String toString() {
        return "{" +
            " id:'" + id + "\'" +
            ", name:'" + name + "\'" +
            ", breed:'" + breed + "\'" +
            ", age:'" + age + "\'" +
            ", gender:'" + gender.toString() + "\'" +
            ", adopter id:'" + adopter + "\'" +
            ", timeStamp:'" + getTimeStamp() + "\'" +
            "}";
    }
    private int age;
    private Gender gender;
    private long adopter;

    public Gender getGender() {
        return this.gender;
    }

    public Long getAdopter() {
        return this.adopter;
    }

    public void setAdopter(long adopter) {
        this.adopter = adopter;
    }

    public Time getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Time timeStamp) {
        this.timeStamp = timeStamp;
    }
    private Time timeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // public AdoptedAnimal adopt(long adopterId) {

    // }


}
