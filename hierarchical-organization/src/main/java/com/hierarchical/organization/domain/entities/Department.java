package com.hierarchical.organization.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseEntity{

    @Column(name = "department_name")
    @NotNull(message = "Department name is compulsory")
    private String departmentName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    private List<Employee> employees;

    @ManyToOne()
    @JoinColumn(name = "directorate_id", referencedColumnName = "id")
    private Directorate directorate;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Directorate getDirectorate() {
        return directorate;
    }

    public void setDirectorate(Directorate directorate) {
        this.directorate = directorate;
    }
}
