package com.db.carshop.employee;



import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.exceptions.EmployeeAlreadyExistsException;
import com.db.carshop.employee.exceptions.EmployeeDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;


    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeInputDto inputDto) {
        try{
            return new ResponseEntity<>(service.createEmployee(inputDto), HttpStatus.CREATED);
        }catch (EmployeeAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeInputDto inputDto, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(service.updateEmployee(inputDto, id), HttpStatus.OK);
        }catch (EmployeeDoesNotExistException  | EmployeeAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(service.getOutputDtoById(id), HttpStatus.OK);
        }catch (EmployeeDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeOutputDto>> findAll() {
        return new ResponseEntity<>(service.getAll(),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EmployeeDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*@PatchMapping("/{id}/car/{carId}/buy")
    public ResponseEntity<Object> buyCar(@PathVariable Long id, @PathVariable Long carId) {
        try{
            service.buyCar(id, carId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CustomerDoesNotExistException | CarDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}/car/{carId}/sale")
    public ResponseEntity<Object> sellCar(@PathVariable Long id, @PathVariable Long carId) {
        try{
            service.sellCar(id, carId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CustomerDoesNotExistException | CarDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/
}
