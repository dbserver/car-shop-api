package com.db.carshop.employee.impl;

import com.db.carshop.employee.EmployeeMapper;
import com.db.carshop.employee.EmployeeRepository;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.exceptions.EmployeeDoesNotExistException;
import com.db.carshop.employee.model.Employee;
import com.db.carshop.employee.util.EmployeeUtil;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
   private EmployeeRepository repository;
   private EmployeeUtil util;
   private EmployeeMapper employeeMapper;

    @Override
    public EmployeeOutputDto createEmployee(EmployeeInputDto inputDto) {
        Employee employee = util.employeeInputDtoToEmployee(inputDto);
        employee = repository.save(employee);
        return util.employeeToOutputDto(employee);
    }

    @Override
    public EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id) {
        Employee employee = findById(id);

        employeeMapper.updateEmployeeFromDto(inputDto, employee);
        repository.save(employee);

        return util.employeeToOutputDto(employee);
    }

    @Override
    public EmployeeOutputDto getById(Long id) {
        return util.employeeToOutputDto(findById(id));
    }

    @Override
    public List<EmployeeOutputDto> getAll() {
       return repository.findAll().stream()
               .map(employee -> util.employeeToOutputDto(employee))
               .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeDoesNotExistException();
        }
        repository.deleteById(id);
    }

    public Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeDoesNotExistException::new);
    }

}
