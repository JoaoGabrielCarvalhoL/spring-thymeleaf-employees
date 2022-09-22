package br.com.carv.employees.exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {
        super(message);
    }

}
