package com.db.carshop.employee.impl;

import com.db.carshop.car.CarService;
import com.db.carshop.car.model.Car;
import com.db.carshop.employee.EmployeeMapper;
import com.db.carshop.employee.EmployeeRepository;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.exceptions.EmployeeAlreadyExistsException;
import com.db.carshop.employee.exceptions.EmployeeDoesNotExistException;
import com.db.carshop.employee.model.Employee;
import com.db.carshop.employee.util.EmployeeUtil;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    private CarService carService;
    private EmployeeUtil util;
    private EmployeeMapper employeeMapper;

    @Override
    public void buyCar(Long employeeId, Long carId) {
        Employee employee = findById(employeeId);
        Car car = carService.findById(carId);

        carService.updateCarAvailable(true, car);
        carService.updatEmployeeBoughtCar(employee, car);
    }

    @Override
    public void sellCar(Long employeeId, Long carId) {
        Employee employee = findById(employeeId);
        Car car = carService.findById(carId);

        carService.updateCarAvailable(false, car);
        carService.updatEmployeeSoldCar(employee, car);
    }

    @Override
    public EmployeeOutputDto createEmployee(EmployeeInputDto inputDto) {
        verifyIfEmailAlreadyExists(inputDto.getEmail());

        Employee employee = util.inputDtoToEmployee(inputDto);
        employee = repository.save(employee);

        return util.employeeToOutputDto(employee);
    }

    @Override
    public EmployeeOutputDto updateEmployee(EmployeeInputDto inputDto, Long id) {
        Employee employee = findById(id);
        verifyIfEmailAlreadyExists(inputDto.getEmail());

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
    public Employee getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(EmployeeDoesNotExistException::new);
    }

    @Override
    public void deleteById(Long id) {
        removeBoughtCarsAndSoldCars(findById(id));

        repository.deleteById(id);
    }

    private Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeDoesNotExistException::new);
    }

    private void verifyIfEmailAlreadyExists(String email) {
        if (repository.findByEmail(email).isPresent()) {
            throw new EmployeeAlreadyExistsException();
        }
    }

    private void removeBoughtCarsAndSoldCars(Employee employee){
        employee.getBoughtCars().forEach(car -> {
            carService.updatEmployeeBoughtCar(null, car);
        });
        employee.getSoldCars().forEach(car -> {
            carService.updatEmployeeSoldCar(null, car);
        });
    }

}
