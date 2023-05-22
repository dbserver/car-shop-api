package com.db.carshop.employee;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeOutputDto createEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id);
    EmployeeOutputDto getOutputDtoById(Long id);
    Employee getById(Long id);
    Employee getByEmail(String email);
    List<EmployeeOutputDto> getAll();
    void deleteById(Long id);

}
