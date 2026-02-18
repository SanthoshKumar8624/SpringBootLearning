package com.sandycode.springbootlearning.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Integer id)
    {
        super("Employee with ID "+id+" not found");
    }
}
