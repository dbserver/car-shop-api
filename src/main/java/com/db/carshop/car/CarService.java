package com.db.carshop.car;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.model.Car;

import java.util.List;

public interface CarService {
    Car createCar(CarDto carDto);
    Car updateCar(CarDto carDto);
    Car findById(Long id);
    List<Car> getAll();
    void deleteById(Long id);
}
