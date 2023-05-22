package com.db.carshop.store.exception;


public class StoreDoesNotExistException extends RuntimeException{
    public StoreDoesNotExistException(){
        super("Loja não existe");
    }
}
