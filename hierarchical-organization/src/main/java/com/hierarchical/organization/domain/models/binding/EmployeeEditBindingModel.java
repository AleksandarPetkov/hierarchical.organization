package com.hierarchical.organization.domain.models.binding;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeEditBindingModel {

    private long id;

    @NotNull(message = "First name cannot be empty!")
    @Size(min = 2, max = 15, message = "First Name must be between 3 AND 15 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be empty!")
    @Size(min = 2, max = 15, message = "Last Name must be between 3 AND 15 characters")
    private String lastName;

    @NotNull(message = "Job Title cannot be empty!")
    @Size(min = 2, max = 50, message = "Job Title must be between 2 AND 50 characters")
    private String jobTitle;

    @Min(value=16, message="age must be equal or greater than 16")
    @Max(value=60, message="age must be equal or less than 60")
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
