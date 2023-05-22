package com.db.carshop.sale.exceptions;


public class SaleDoesNotExistException extends RuntimeException{
    public SaleDoesNotExistException(){
        super("Venda não existe");
    }
}
