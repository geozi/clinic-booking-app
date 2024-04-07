package com.myclinic.service.exceptions;

import java.io.Serial;

/**
 * Custom exception class indicating that an entity with a given ID already exists.
 * This exception is typically thrown when attempting to create a resource that is already present.
 */
public class EntityAlreadyExistsException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(Class<?> entityClass, Long id) {
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " does not exist");
    }
}