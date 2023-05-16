package com.db.carshop.customer;


import com.db.carshop.customer.dto.CustomerDto;
import com.db.carshop.customer.exceptions.CustomerAlreadyExistsException;
import com.db.carshop.customer.exceptions.CustomerDoesNotExistException;
import com.db.carshop.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDto dto) {
        try{
            return new ResponseEntity<>(customerService.createCustomer(dto), HttpStatus.CREATED);
        }catch (CustomerAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerDto dto, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(customerService.updateCustomer(dto, id), HttpStatus.OK);
        }catch (CustomerDoesNotExistException | CustomerAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
        }catch (CustomerDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerService.getAll(),
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try{
            customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CustomerDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
