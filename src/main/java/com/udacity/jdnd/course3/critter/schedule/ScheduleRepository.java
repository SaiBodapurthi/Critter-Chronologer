package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //Finds all schedules that contain a specific pet.
    List<Schedule> findAllByPets_Id(Long petId);

    //Finds all schedules that contain a specific employee.
    List<Schedule> findAllByEmployees_Id(Long employeeId);
    
    //Finds all schedules containing any pet belonging to a specific customer.
    // This connects Schedule -> Pet -> Customer.
    List<Schedule> findAllByPets_Customer_Id(Long customerId);
}