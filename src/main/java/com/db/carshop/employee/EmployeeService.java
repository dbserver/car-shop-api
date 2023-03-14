package com.db.carshop.employee;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;

import java.util.List;

public interface EmployeeService {
    EmployeeOutputDto createEmployee(EmployeeInputDto carDto);
    EmployeeOutputDto updateEmployee(EmployeeInputDto carDto);
    EmployeeOutputDto findById(Long id);
    List<EmployeeOutputDto> getAll();
    void deleteById(Long id);
}
