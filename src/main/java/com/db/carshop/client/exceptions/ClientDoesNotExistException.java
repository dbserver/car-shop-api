package com.db.carshop.client.exceptions;

public class ClientDoesNotExistException extends RuntimeException{
    public ClientDoesNotExistException(){
        super("Client does not exist");
    }
}
