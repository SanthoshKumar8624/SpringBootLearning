package com.sandycode.springbootlearning.Controller;

import com.sandycode.springbootlearning.DTO.EmployeeRequestDTO;
import com.sandycode.springbootlearning.DTO.EmployeeResponseDTO;
import com.sandycode.springbootlearning.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET ALL
    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return employeeService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public EmployeeResponseDTO getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    // POST
    @PostMapping
    public EmployeeResponseDTO insert(@Valid @RequestBody EmployeeRequestDTO dto) {
        return employeeService.insert(dto);
    }

    // POST ALL
    @PostMapping("/all")
    public List<EmployeeResponseDTO> insertAll(@RequestBody List<EmployeeRequestDTO> dtos) {
        return employeeService.insertAll(dtos);
    }

    // PUT
    @PutMapping("/{id}")
    public EmployeeResponseDTO update(@PathVariable Integer id, @RequestBody EmployeeRequestDTO dto) {
        return employeeService.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return  "Employee with id " + id + " has been deleted.";
    }
}