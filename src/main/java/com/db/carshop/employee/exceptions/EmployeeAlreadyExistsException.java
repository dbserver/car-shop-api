package com.db.carshop.employee.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(){
        super("Employee already exists");
    }
}
