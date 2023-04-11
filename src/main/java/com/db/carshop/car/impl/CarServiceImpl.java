package com.db.carshop.car.impl;


import com.db.carshop.car.CarMapper;
import com.db.carshop.car.CarRepository;
import com.db.carshop.car.CarService;
import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.exceptions.CarDoesNotExistException;
import com.db.carshop.car.model.Car;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository repository;
    private CarMapper carMapper;


    @Override
    public Car createCar(CarDto carDto) {
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .color(carDto.getColor())
                .fuel(carDto.getFuel())
                .model(carDto.getModel())
                .kmPerHour(carDto.getKmPerHour())
                .licensePlate(carDto.getLicensePlate())
                .numberPassengers(carDto.getNumberPassengers())
                .additional(carDto.getAdditional())
                .available(true)
                .build();

        return repository.save(car);
    }


    @Override
    public Car updateCar(CarDto dto, Long id) {
        Car car = findById(id);
        carMapper.updateCarFromDto(dto, car);

        return repository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarDoesNotExistException());
    }

    @Override
    public List<Car> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {

        if (!repository.existsById(id)) {
            throw new CarDoesNotExistException();
        }
        repository.deleteById(id);
    }
}
