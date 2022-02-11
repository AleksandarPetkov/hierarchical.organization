package com.hierarchical.organization.web;

import com.hierarchical.organization.domain.models.view.DepartmentView;
import com.hierarchical.organization.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public ModelAndView index(ModelAndView modelAndView) {
        //TODO
        modelAndView.setViewName("department");
        Set<DepartmentView> departmentViews = this.departmentService.getDepartmentsInfo();
        modelAndView.addObject("departmentViews", departmentViews);
        return modelAndView;
    }
}
