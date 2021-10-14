package com.techawarelabs.employeemanager.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ProductNotFoundException(Long id) {
        super("The Product with Id " + id + " not found!");
    }
}
