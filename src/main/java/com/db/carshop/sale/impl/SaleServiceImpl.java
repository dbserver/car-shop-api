package com.db.carshop.sale.impl;

import com.db.carshop.car.CarService;
import com.db.carshop.car.model.Car;
import com.db.carshop.customer.CustomerService;
import com.db.carshop.customer.exceptions.CustomerDoesNotExistException;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.sale.SaleMapper;
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
    private SaleMapper mapper;
    private CarService carService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    @Override
    public Sale createSale(SaleDto dto) {
        Car car = carService.getById(dto.getCarId());

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

        mapper.updateSaleFromDto(dto, sale);

        carService.updateCarAvailable(false, carService.getById(dto.getCarId()));
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
        if (!repository.existsById(id)) {
            throw new CustomerDoesNotExistException();
        }
        repository.deleteById(id);
    }
}
