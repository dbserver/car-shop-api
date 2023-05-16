package com.db.carshop.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(){
        super("Customer already exists");
    }
}
