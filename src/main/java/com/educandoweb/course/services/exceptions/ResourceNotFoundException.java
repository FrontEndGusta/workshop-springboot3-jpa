package com.educandoweb.course.services.exceptions;

import java.io.Serial;

//compilador não obriga tratar as exceções RuntimeException
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        //construtor da superclasse
        super("Resource not found. Id " + id);
    }
}
