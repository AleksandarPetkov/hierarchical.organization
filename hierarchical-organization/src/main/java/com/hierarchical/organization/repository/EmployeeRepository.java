package com.hierarchical.organization.repository;

import com.hierarchical.organization.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employees e WHERE e.first_name LIKE %:keyword% OR e.last_name LIKE %:keyword% OR e.unique_identifier LIKE %:keyword% OR e.job_title LIKE %:keyword% OR e.age LIKE %:keyword%", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}
