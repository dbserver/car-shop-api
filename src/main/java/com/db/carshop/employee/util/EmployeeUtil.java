package com.db.carshop.employee.util;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;


public interface EmployeeUtil {
    Employee inputDtoToEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto employeeToOutputDto(Employee employee);
}
