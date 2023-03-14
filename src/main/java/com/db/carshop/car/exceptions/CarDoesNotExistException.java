package com.db.carshop.car.exceptions;


public class CarDoesNotExistException extends RuntimeException{
    public CarDoesNotExistException(){
        super("Car does not exist");
    }
}
