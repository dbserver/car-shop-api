package com.db.carshop.car;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.model.Car;
import com.db.carshop.employee.model.Employee;

import java.util.List;

public interface CarService {
    Car createCar(CarDto carDto);
    Car updateCar(CarDto carDto, Long id);
    Car updateCarAvailable(Boolean available, Car car);
    Car updatEmployeeBoughtCar(Employee employee, Car car);
    Car updatEmployeeSoldCar(Employee employee, Car car);
    Car findById(Long id);
    List<Car> getAll();
    void deleteById(Long id);
}
