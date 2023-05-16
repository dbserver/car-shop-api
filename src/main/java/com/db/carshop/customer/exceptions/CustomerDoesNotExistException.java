package com.db.carshop.customer.exceptions;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(){
        super("Employee does not exist");
    }
}
