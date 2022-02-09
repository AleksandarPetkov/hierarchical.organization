package com.hierarchical.organization.domain.entities;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employees")
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    @Size(min = 2, max = 15, message = "First Name must be between 3 AND 15 characters")
    @NotNull(message = "First name is compulsory")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 15, message = "Last Name must be between 3 AND 15 characters")
    @NotNull(message = "Last name is compulsory")
    private String lastName;

    @Column(name = "unique_identifier", unique = true)
    @Size(min = 10, max = 10, message = "Identifier must be 10 characters long")
    @NotNull(message = "Identifier is compulsory")
    private String uniqueIdentifier;

    @Column(name = "job_title")
    @NotNull(message = "Job Title is compulsory")
    private String jobTitle;

    @Column(name = "age")
    private Integer age;

    @ManyToOne()
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    private Set<Employee> subordinates = new HashSet<Employee>();

    @ManyToOne()
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToOne()
    @JoinColumn(name = "directorate_id", referencedColumnName = "id")
    private Directorate directorate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Directorate getDirectorate() {
        return directorate;
    }

    public void setDirectorate(Directorate directorate) {
        this.directorate = directorate;
    }
}
