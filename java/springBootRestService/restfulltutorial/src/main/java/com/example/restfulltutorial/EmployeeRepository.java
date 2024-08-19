package com.example.restfulltutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query(value = "DELETE FROM Employee e where e.id = ?1")
    int customDeleteById(Long id);
}
