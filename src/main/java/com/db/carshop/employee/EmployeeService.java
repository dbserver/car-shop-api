package com.db.carshop.employee;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;

import java.util.List;

public interface EmployeeService {
    EmployeeOutputDto createEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id);
    EmployeeOutputDto getById(Long id);
    List<EmployeeOutputDto> getAll();
    void deleteById(Long id);
}
