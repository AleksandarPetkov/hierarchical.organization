package com.hierarchical.organization.service;

import com.hierarchical.organization.domain.entities.Department;
import com.hierarchical.organization.domain.entities.Employee;
import com.hierarchical.organization.domain.models.view.DepartmentView;
import com.hierarchical.organization.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Set<DepartmentView> getDepartmentsInfo() {
        //TODO
        Set<DepartmentView> departmentViews = new HashSet<>();
        List<Department> departments = this.departmentRepository.findAll();

        for (Department department : departments) {
            DepartmentView view = new DepartmentView();
            view.setDepartmentName(department.getDepartmentName());
            view.setManagerName(getManagerName(department));
            view.setEmployeesCount(department.getEmployees().size());

            departmentViews.add(view);
        }

        return departmentViews;
    }

    private String getManagerName(Department department){
        //TODO
        if (!department.getEmployees().isEmpty()){
            return department.getEmployees().get(0).getManager().getFirstName();
        }
        return "No Manager";
    }
}
