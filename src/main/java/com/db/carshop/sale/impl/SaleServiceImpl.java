package com.db.carshop.sale.impl;

import com.db.carshop.car.CarService;
import com.db.carshop.car.exceptions.CarAlreadySoldException;
import com.db.carshop.car.model.Car;
import com.db.carshop.customer.CustomerService;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.sale.SaleRepository;
import com.db.carshop.sale.SaleService;
import com.db.carshop.sale.dto.SaleDto;
import com.db.carshop.sale.exceptions.SaleDoesNotExistException;
import com.db.carshop.sale.model.Sale;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SaleServiceImpl implements SaleService {
    private SaleRepository repository;
    private CarService carService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    @Override
    public Sale createSale(SaleDto dto) {
        Car car = carService.getById(dto.getCarId());

        verifyIfCarAlreadySold(car.getAvailable());

        Sale sale = Sale.builder()
                .car(car)
                .customer(customerService.getById(dto.getCustomerId()))
                .employee(employeeService.getById(dto.getEmployeeId()))
                .build();

        carService.updateCarAvailable(false, car);
        return repository.save(sale);
    }

    @Override
    public Sale updateSale(SaleDto dto, Long id) {
        Sale sale = getById(id);

        Car car = carService.getById(dto.getCarId());
        verifyIfCarAlreadySoldInUpdate(car.getAvailable(), car, sale.getCar());

        if(dto.getCarId() != null){
            carService.updateCarAvailable(true, sale.getCar());
            sale.setCar(car);
        }
        if(dto.getCustomerId() != null){
            sale.setCustomer(customerService.getById(dto.getCustomerId()));
        }
        if(dto.getEmployeeId() != null){
            sale.setEmployee(employeeService.getById(dto.getEmployeeId()));
        }

        carService.updateCarAvailable(false, car);
            return repository.save(sale);
    }

    @Override
    public Sale getById(Long id) {
        return repository.findById(id)
                .orElseThrow(SaleDoesNotExistException::new);
    }

    @Override
    public List<Sale> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Sale sale = getById(id);
        carService.updateCarAvailable(true, sale.getCar());

        repository.deleteById(id);
    }

    public void verifyIfCarAlreadySold(Boolean available){
        if(available.equals(Boolean.FALSE)){
            throw new CarAlreadySoldException();
        }
    }

    public void verifyIfCarAlreadySoldInUpdate(Boolean available, Car carOfDto, Car saleCar){
        if(available.equals(Boolean.FALSE) &&
                !carOfDto.getId().equals(saleCar.getId())){
            throw new CarAlreadySoldException();
        }
    }
}
