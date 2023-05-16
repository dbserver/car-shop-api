package com.db.carshop.sale.exceptions;


public class SaleDoesNotExistException extends RuntimeException{
    public SaleDoesNotExistException(){
        super("Sale does not exist");
    }
}
