package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Finds all employees who are available on a specific day of the week.
    List<Employee> findAllByDaysAvailableContaining(DayOfWeek dayOfWeek);
}