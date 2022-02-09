package com.hierarchical.organization.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "directorates")
public class Directorate extends BaseEntity{

    @Column(name = "directorate_name")
    @NotNull(message = "Directorate name is compulsory")
    private String directorateName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "directorate", targetEntity = Department.class)
    private List<Department> departments;

    @OneToOne(mappedBy = "directorate")
    private Employee director;

    public String getDirectorateName() {
        return directorateName;
    }

    public void setDirectorateName(String directorateName) {
        this.directorateName = directorateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }
}
