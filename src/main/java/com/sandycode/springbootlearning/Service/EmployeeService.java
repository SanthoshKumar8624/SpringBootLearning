package com.sandycode.springbootlearning.Service;

import com.sandycode.springbootlearning.DTO.EmployeeRequestDTO;
import com.sandycode.springbootlearning.DTO.EmployeeResponseDTO;
import com.sandycode.springbootlearning.Entity.Employee;
import com.sandycode.springbootlearning.Exception.EmployeeNotFoundException;
import com.sandycode.springbootlearning.Exception.PasswordMismatchException;
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

    //    id - name - email - DOB- password - ConfirmPassword

//    // DTO → Entity
//    private Employee toEntity(EmployeeRequestDTO dto) {
//        Employee e = new Employee();
//        e.setId(dto.getId());
//        e.setName(dto.getName());
//        e.setEmail(dto.getEmail());
//        e.setDOB(dto.getDOB());
//        e.setPassword(dto.getPassword());
//        return e;
//    }
//
//    // Entity → DTO
//    private EmployeeRequestDTO toDTO(Employee e) {
//        EmployeeRequestDTO dto = new EmployeeRequestDTO();
//        dto.setId(e.getId());
//        dto.setName(e.getName());
//        dto.setEmail(e.getEmail());
//        dto.setDOB(e.getDOB());
//        dto.setPassword(e.getPassword());
//        return dto;
//    }

    //EmployeeRequestDTO → Employee
    private Employee toEntity(EmployeeRequestDTO ReqDTO) {
        Employee e = new Employee();
        e.setId(ReqDTO.getId());
        e.setName(ReqDTO.getName());
        e.setEmail(ReqDTO.getEmail());
        e.setDOB(ReqDTO.getDOB());
        if(ReqDTO.getPassword()!=null && !ReqDTO.getPassword().isEmpty() ){
            if(!ReqDTO.getPassword().equals(ReqDTO.getConfirmPassword() )){
                throw new PasswordMismatchException();
            }
            e.setPassword(ReqDTO.getPassword());
        }
        return e;
    }
    //Employee → EmployeeResponseDTO
    private EmployeeResponseDTO toResDTO(Employee e) {
        return new EmployeeResponseDTO(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getDOB()
                //here we aren't returning the password in the response DTO for security reasons
        );
    }

    // GET ALL
    public List<EmployeeResponseDTO> getAll() {
        List<Employee> employees = repository.findAll();
        if(employees.isEmpty())
        {
            throw new EmployeeNotFoundException(null);//if no employees,return null.
        }
        List<EmployeeResponseDTO> dtoList = new ArrayList<>();
        for (Employee e : employees) {
            dtoList.add(toResDTO(e));
        }
        return dtoList;
    }

    // GET BY ID
    public EmployeeResponseDTO getById(Integer id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        Employee employee = optional.get();
        return toResDTO(employee);
    }

    // POST (insert)
    public EmployeeResponseDTO insert(EmployeeRequestDTO dto) {
        Employee employee = toEntity(dto);
        Employee saved = repository.save(employee);
        return toResDTO(saved);
    }

    // POST ALL (insert all)
    public List<EmployeeResponseDTO> insertAll(List<EmployeeRequestDTO> dtos) {
        List<Employee> entityList = new ArrayList<>();
        for (EmployeeRequestDTO dto : dtos) {
            entityList.add(toEntity(dto));
        }

        List<Employee> savedEntities = repository.saveAll(entityList);
        List<EmployeeResponseDTO> result = new ArrayList<>();

        for (Employee e : savedEntities) {
            result.add(toResDTO(e));
        }

        return result;
    }

    // PUT (Update)
    public EmployeeResponseDTO update(Integer id, EmployeeRequestDTO dto) {
        Optional<Employee> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }

        Employee existing = optional.get();
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setDOB(dto.getDOB());
        if(dto.getPassword()!=null && !dto.getPassword().isEmpty() ) {
            if (!dto.getPassword().equals(dto.getConfirmPassword())) {
                throw new PasswordMismatchException();
            }
            existing.setPassword(dto.getPassword());
        }
        Employee updated = repository.save(existing);
        return toResDTO(updated);
    }

    // DELETE
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
    }
}