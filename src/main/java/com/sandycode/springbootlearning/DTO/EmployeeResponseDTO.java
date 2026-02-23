package com.sandycode.springbootlearning.DTO;

public class EmployeeResponseDTO
{
    private Integer id;
    private String name;
    private String email;
    private String DOB;

    public EmployeeResponseDTO(){}

    public EmployeeResponseDTO(Integer id, String name, String email, String DOB) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
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
}
