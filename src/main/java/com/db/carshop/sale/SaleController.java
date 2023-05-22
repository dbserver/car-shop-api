package com.db.carshop.sale;

import com.db.carshop.car.exceptions.CarAlreadySoldException;
import com.db.carshop.car.exceptions.CarDoesNotExistException;
import com.db.carshop.customer.exceptions.CustomerDoesNotExistException;
import com.db.carshop.employee.exceptions.EmployeeDoesNotExistException;
import com.db.carshop.sale.dto.SaleDto;
import com.db.carshop.sale.exceptions.SaleDoesNotExistException;
import com.db.carshop.sale.model.Sale;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sale")
public class SaleController {

    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Object> createSale(@RequestBody SaleDto dto) {
        try{
            return new ResponseEntity<>(saleService.createSale(dto), HttpStatus.CREATED);
        }catch (CustomerDoesNotExistException |
                CarDoesNotExistException |
                CarAlreadySoldException |
                EmployeeDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSale(@RequestBody SaleDto dto, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(saleService.updateSale(dto, id), HttpStatus.OK);
        }catch (SaleDoesNotExistException |
                CustomerDoesNotExistException |
                CarDoesNotExistException |
                CarAlreadySoldException |
                EmployeeDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(saleService.getById(id), HttpStatus.OK);
        }catch (SaleDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return new ResponseEntity<>(saleService.getAll(),
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try{
            saleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (SaleDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
