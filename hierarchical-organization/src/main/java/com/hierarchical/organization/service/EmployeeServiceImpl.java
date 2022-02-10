package com.hierarchical.organization.service;

import com.hierarchical.organization.domain.entities.Employee;
import com.hierarchical.organization.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> searchEmployeesByKeyword(String keyword) {
        if (!keyword.isBlank()){
            return this.employeeRepository.findByKeyword(keyword);
        }
        return getAllEmployees();
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
