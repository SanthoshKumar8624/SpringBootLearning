package com.sandycode.springbootlearning.Respository;

import com.sandycode.springbootlearning.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
}