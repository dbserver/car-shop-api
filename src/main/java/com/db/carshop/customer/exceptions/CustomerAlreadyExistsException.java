package com.db.carshop.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(){
        super("Cliente já existe");
    }
}
