package com.myclinic.service.exceptions;

import java.io.Serial;

/**
 * Custom exception class indicating that an entity with a given ID does not exist.
 * This exception is typically thrown when attempting to retrieve or manipulate an entity
 * that is expected to be present but is not found in the database.
 */
public class EntityNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entityClass, Long id) {
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " does not exist");
    }
}