package com.hierarchical.organization.service;

import com.hierarchical.organization.domain.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> searchEmployeesByKeyword(String keyword);

    List<Employee> getAllEmployees();
}
