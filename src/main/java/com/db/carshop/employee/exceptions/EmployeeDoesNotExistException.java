package com.db.carshop.employee.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(){
        super("Employee does not exist");
    }
}
