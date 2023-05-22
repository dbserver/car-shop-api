package com.db.carshop.employee.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(){
        super("Funcionário não existe");
    }
}
