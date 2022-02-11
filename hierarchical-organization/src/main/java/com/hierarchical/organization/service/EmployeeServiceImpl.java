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

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return  employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    @Override
    public Employee editEmployee(Long id, Employee modelEmployee) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't find Employee with id " + id));

        employee.setFirstName(modelEmployee.getFirstName());
        employee.setLastName(modelEmployee.getLastName());
        employee.setJobTitle(modelEmployee.getJobTitle());
        employee.setAge(modelEmployee.getAge());

        this.employeeRepository.save(employee);
        return employee;
    }
}
