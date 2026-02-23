package com.sandycode.springbootlearning.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {
    private Integer id;
    @NotBlank(message = "Name can't be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    @Email
    @NotBlank(message = "Email can't be blank")
    private String email;
    @NotBlank(message = "Data of Birth can't be blank")
    private String DOB;
    @NotBlank(message = "Password can't be blank")
    private String Password;
    @NotBlank(message = "Confirm Password can't be blank")
    private String ConfirmPassword;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(Integer id, String name, String email, String DOB, String Password, String ConfirmPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.Password = Password;
        this.ConfirmPassword =ConfirmPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}