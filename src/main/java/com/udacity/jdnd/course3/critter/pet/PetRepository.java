package com.udacity.jdnd.course3.critter.pet;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    /**
     * Finds all pets that belong to a specific customer (owner).
     */
    List<Pet> findAllByCustomer_Id(Long customerId);
}