package com.db.carshop.store.exception;


public class StoreDoesNotExistException extends RuntimeException{
    public StoreDoesNotExistException(){
        super("Store does not exist");
    }
}
