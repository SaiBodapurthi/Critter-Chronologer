package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Pet savePet(Pet pet, Long ownerId) {
        Customer customer = null;
        if (ownerId != null && ownerId != 0) {
            customer = customerRepository.findById(ownerId).orElse(null);
            pet.setCustomer(customer);
        }
        
        // Save the pet first. This generates the ID and Foreign Key.
        Pet savedPet = petRepository.save(pet);

        // Now add the saved pet to the customer's list in memory so the return object is correct.
        // We do NOT save the customer again.
        if (customer != null) {
            customer.addPet(savedPet);
        }

        return savedPet;
    }

    public Pet getPet(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Long ownerId) {
        return petRepository.findAllByCustomer_Id(ownerId);
    }
}