package com.sandycode.springbootlearning.Service;

import com.sandycode.springbootlearning.DTO.EmployeeDTO;
import com.sandycode.springbootlearning.Entity.Employee;
import com.sandycode.springbootlearning.Exception.EmployeeNotFoundException;
import com.sandycode.springbootlearning.Respository.EmployeeRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    private final EmployeeRespository repository;

    public EmployeeService(EmployeeRespository repository) {
        this.repository = repository;
    }

    // DTO → Entity
    private Employee toEntity(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setRole(dto.getRole());
        return e;
    }

    // Entity → DTO
    private EmployeeDTO toDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setRole(e.getRole());
        return dto;
    }

    // GET ALL
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = repository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employee e : employees) {
            dtoList.add(toDTO(e));
        }
        return dtoList;
    }

    // GET BY ID
    public EmployeeDTO getById(Integer id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        Employee employee = optional.get();
        return toDTO(employee);
    }

    // POST (insert)
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee employee = toEntity(dto);
        Employee saved = repository.save(employee);
        return toDTO(saved);
    }

    // POST ALL (insert all)
    public List<EmployeeDTO> insertAll(List<EmployeeDTO> dtos) {
        List<Employee> entityList = new ArrayList<>();
        for (EmployeeDTO dto : dtos) {
            entityList.add(toEntity(dto));
        }

        List<Employee> savedEntities = repository.saveAll(entityList);
        List<EmployeeDTO> result = new ArrayList<>();

        for (Employee e : savedEntities) {
            result.add(toDTO(e));
        }

        return result;
    }

    // PUT (Update)
    public EmployeeDTO update(Integer id, EmployeeDTO dto) {
        Optional<Employee> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }

        Employee existing = optional.get();
        existing.setName(dto.getName());
        existing.setRole(dto.getRole());

        Employee updated = repository.save(existing);
        return toDTO(updated);
    }

    // DELETE
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
    }
}