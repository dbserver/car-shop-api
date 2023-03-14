package com.db.carshop.employee.impl;

import com.db.carshop.employee.EmployeeRepository;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.exceptions.EmployeeDoesNotExistException;
import com.db.carshop.employee.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
   private EmployeeRepository repository;

    @Override
    public EmployeeOutputDto createEmployee(EmployeeInputDto carDto) {
        return null;
    }

    @Override
    public EmployeeOutputDto updateEmployee(EmployeeInputDto carDto) {
        return null;
    }

    @Override
    public EmployeeOutputDto findById(Long id) {
//       Employee employee =  repository.findById(id)
//                .orElseThrow(() -> new CarDoesNotExistException());
//
//        return EmployeeOutputDto.builder()
//                .type(employee.getType())
//                .build();
        return null;
    }

    @Override
    public List<EmployeeOutputDto> getAll() {
       return null;
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeDoesNotExistException();
        }
        repository.deleteById(id);
    }
}
