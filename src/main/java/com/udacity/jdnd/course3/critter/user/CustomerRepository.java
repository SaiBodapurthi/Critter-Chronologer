package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // This interface inherits standard CRUD methods (save, findById, delete, etc.)
}