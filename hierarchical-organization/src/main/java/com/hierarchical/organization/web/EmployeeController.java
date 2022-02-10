package com.hierarchical.organization.web;

import com.hierarchical.organization.domain.entities.Employee;
import com.hierarchical.organization.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ModelAndView index(ModelAndView modelAndView, String keyword) {
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @GetMapping("/search-employee")
    public ModelAndView searchEmployee(ModelAndView modelAndView, String keyword) {
        List<Employee> employees;
        if (keyword != null){
            employees = this.employeeService.searchEmployeesByKeyword(keyword);
        } else {
            employees = this.employeeService.getAllEmployees();
        }
        modelAndView.addObject("employees", employees );
        modelAndView.setViewName("employee");
        return modelAndView;
    }
}

