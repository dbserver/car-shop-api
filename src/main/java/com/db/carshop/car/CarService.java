package com.db.carshop.car;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.model.Car;
import com.db.carshop.employee.model.Employee;

import java.util.List;

public interface CarService {
    Car createCar(CarDto carDto);
    Car updateCar(CarDto carDto, Long id);
    Car updateCarAvailable(Boolean available, Car car);
    Car getById(Long id);
    List<Car> getAll();
    void deleteById(Long id);
}
