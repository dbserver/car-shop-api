package com.db.carshop.employee.impl;

import com.db.carshop.employee.EmployeeRepository;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.exceptions.EmployeeAlreadyExistsException;
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

    @Override
    public EmployeeOutputDto createEmployee(EmployeeInputDto inputDto) {
        verifyIfEmailAlreadyExists(inputDto.getEmail());

        Employee employee = util.inputDtoToEmployee(inputDto);
        employee = repository.save(employee);

        return util.employeeToOutputDto(employee);
    }

    @Override
    public EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id) {
        verifyIfEmailAlreadyExistsInUpdate(id,inputDto.getEmail());

        Employee employee = getById(id);

        if(inputDto.getName() != null){
            employee.setName(inputDto.getName());
        }
        if(inputDto.getEmail() != null){
            employee.getUser().setEmail(inputDto.getEmail());
        }
        if(inputDto.getPassword() != null){
            employee.getUser().setPassword(inputDto.getPassword());
        }

        employee = repository.save(employee);


        return util.employeeToOutputDto(employee);
    }

    @Override
    public EmployeeOutputDto getOutputDtoById(Long id) {
        return util.employeeToOutputDto(getById(id));
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeDoesNotExistException::new);
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


    @Override
    public Employee getByEmail(String email) {
        return repository.findByUserEmail(email)
                .orElseThrow(EmployeeDoesNotExistException::new);
    }

    private void verifyIfEmailAlreadyExists(String email) {
        if (repository.findByUserEmail(email).isPresent()) {
            throw new EmployeeAlreadyExistsException();
        }
    }

    private void verifyIfEmailAlreadyExistsInUpdate(Long employeeId, String email) {
        Employee employeeOfDTO= repository.findByUserEmail(email)
                .orElse(null);

        if(employeeOfDTO!= null &&
                !employeeOfDTO.getId().equals(employeeId)){
            throw new EmployeeAlreadyExistsException();
        }
    }

}
