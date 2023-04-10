package com.db.carshop.employee.util;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;


public interface EmployeeUtil {
    EmployeeOutputDto employeeToOutputDto(Employee employee);
    EmployeeOutputDto employeeInputToOutputDto(EmployeeInputDto inputDto);
}
