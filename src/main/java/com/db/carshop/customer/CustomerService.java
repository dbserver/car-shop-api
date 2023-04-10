package com.db.carshop.customer;

import com.db.carshop.customer.model.Customer;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;

import java.util.List;

public interface CustomerService {
    Customer createEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto);
    EmployeeOutputDto findById(Long id);
    List<EmployeeOutputDto> getAll();
    void deleteById(Long id);
}
