package com.sandycode.springbootlearning.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String DOB;
    private String Password;

    public Employee() {}

    public Employee(Integer id, String name,String email, String DOB, String Password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.Password = Password;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(DOB, employee.DOB) && Objects.equals(Password, employee.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, DOB, Password);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}