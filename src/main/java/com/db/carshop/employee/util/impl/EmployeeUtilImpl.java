package com.db.carshop.employee.util.impl;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;
import com.db.carshop.employee.util.EmployeeUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeUtilImpl implements EmployeeUtil {
    @Override
    public EmployeeOutputDto employeeToOutputDto(Employee employee) {
        EmployeeOutputDto dto = new EmployeeOutputDto();
        dto.setId(employee.getId());
        dto.setType(employee.getType());
        dto.setName(employee.getName());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        dto.setAddress(employee.getAddress());
        dto.setCpf(employee.getCpf());

        return dto;
    }

    @Override
    public EmployeeOutputDto employeeInputToOutputDto(EmployeeInputDto inputDto) {
        EmployeeOutputDto dto = new EmployeeOutputDto();
        dto.setType(inputDto.getType());
        dto.setName(inputDto.getName());
        dto.setPhone(inputDto.getPhone());
        dto.setEmail(inputDto.getEmail());
        dto.setAddress(inputDto.getAddress());
        dto.setCpf(inputDto.getCpf());

        return dto;
    }
}
