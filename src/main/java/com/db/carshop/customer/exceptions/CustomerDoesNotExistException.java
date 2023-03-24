package com.db.carshop.customer.exceptions;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(){
        super("Customer does not exist");
    }
}
