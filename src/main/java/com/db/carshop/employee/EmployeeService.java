package com.db.carshop.employee;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    void buyCar(Long employeeId, Long carId);
    void sellCar(Long employeeId, Long carId);
    EmployeeOutputDto createEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id);
    EmployeeOutputDto getById(Long id);
    List<EmployeeOutputDto> getAll();
    Employee getByEmail(String email);
    void deleteById(Long id);
}
