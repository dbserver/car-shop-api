package com.db.carshop.store.exception;


public class StoreAlreadyExistsException extends RuntimeException{
    public StoreAlreadyExistsException(){
        super("Loja já existe");
    }
}
