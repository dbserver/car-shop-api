package com.db.carshop.store;

import com.db.carshop.store.dto.StoreDto;
import com.db.carshop.store.exception.StoreAlreadyExistsException;
import com.db.carshop.store.exception.StoreDoesNotExistException;
import com.db.carshop.store.model.Store;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Object> createStore(@RequestBody StoreDto dto) {
        try{
            return new ResponseEntity<>(storeService.createStore(dto), HttpStatus.CREATED);
        }catch (StoreAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStore(@RequestBody StoreDto dto, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(storeService.updateStore(dto, id), HttpStatus.OK);
        }catch (StoreDoesNotExistException | StoreAlreadyExistsException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(storeService.findById(id), HttpStatus.OK);
        }catch (StoreDoesNotExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Store>> findAll() {
        return new ResponseEntity<>(storeService.getAll(),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try{
            storeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (StoreDoesNotExistException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DataIntegrityViolationException dataException){
            return new ResponseEntity<>("Não é possivel excluir uma loja que possua carros ou funcionários",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
