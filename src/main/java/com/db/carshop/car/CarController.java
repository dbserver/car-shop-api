package com.db.carshop.car;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.exceptions.CarDoesNotExistException;
import com.db.carshop.car.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody CarDto dto) {
        try{
            return new ResponseEntity<>(carService.createCar(dto), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar(@RequestBody CarDto dto, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(carService.updateCar(dto, id), HttpStatus.OK);
        }catch (CarDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
        }catch (CarDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        return new ResponseEntity<>(carService.getAll(),
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try{
            carService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CarDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
