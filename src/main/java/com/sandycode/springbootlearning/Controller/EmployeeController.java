package com.sandycode.springbootlearning.Controller;

import com.sandycode.springbootlearning.DTO.EmployeeDTO;
import com.sandycode.springbootlearning.Service.EmployeeService;
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
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    // POST
    @PostMapping
    public EmployeeDTO insert(@RequestBody EmployeeDTO dto) {
        return employeeService.insert(dto);
    }

    // POST ALL
    @PostMapping("/all")
    public List<EmployeeDTO> insertAll(@RequestBody List<EmployeeDTO> dtos) {
        return employeeService.insertAll(dtos);
    }

    // PUT
    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Integer id, @RequestBody EmployeeDTO dto) {
        return employeeService.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return  "Employee with id " + id + " has been deleted.";
    }
}