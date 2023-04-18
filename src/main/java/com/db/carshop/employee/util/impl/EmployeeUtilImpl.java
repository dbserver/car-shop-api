package com.db.carshop.employee.util.impl;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;
import com.db.carshop.employee.util.EmployeeUtil;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class EmployeeUtilImpl implements EmployeeUtil {

    @Override
    public Employee inputDtoToEmployee(EmployeeInputDto inputDto) {
        return  Employee.builder()
                .password(inputDto.getPassword())
                .type(inputDto.getType())
                .boughtCars(new ArrayList<>())
                .soldCars(new ArrayList<>())
                .name(inputDto.getName())
                .phone(inputDto.getPhone())
                .email(inputDto.getEmail())
                .address(inputDto.getAddress())
                .cpf(inputDto.getCpf())
                .build();
    }

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
        dto.setBoughtCars(employee.getBoughtCars());
        dto.setCarsSold(employee.getSoldCars());

        return dto;
    }

}
