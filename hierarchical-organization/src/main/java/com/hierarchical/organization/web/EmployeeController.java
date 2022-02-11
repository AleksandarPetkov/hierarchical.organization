package com.hierarchical.organization.web;

import com.hierarchical.organization.domain.entities.Employee;
import com.hierarchical.organization.domain.models.binding.EmployeeEditBindingModel;
import com.hierarchical.organization.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
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

    @GetMapping("delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/edit-employee/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = this.employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid EmployeeEditBindingModel employee,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "update-employee";
        }

        this.employeeService.editEmployee(id, this.modelMapper.map(employee, Employee.class));
        return "redirect:/employee";
    }

    @GetMapping("/add-employee")
    public ModelAndView showAddForm() {
        return new ModelAndView("add-employee", "employee", new Employee());
    }

    @PostMapping("/put-employee")
    public String createEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            return "add-employee";
        }

        this.employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
}

