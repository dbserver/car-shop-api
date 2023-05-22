package com.db.carshop.car.exceptions;


public class CarAlreadySoldException extends RuntimeException{
    public CarAlreadySoldException(){
        super("Carro já foi vendido");
    }
}
