package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String notes;

    // A Customer can have many Pets.
    // mappedBy = "customer" refers to the 'customer' field in the Pet class (we will create this next).
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, targetEntity = Pet.class)
    private List<Pet> pets;

    // Getters and Setters
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // Helper method to add a pet to the customer's list
    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new java.util.ArrayList<>();
        }
        pets.add(pet);
    }
}