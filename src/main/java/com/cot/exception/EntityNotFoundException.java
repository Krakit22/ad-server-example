package com.cot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private EntityNotFoundException(Class clazz, String by, String searchString) {
        super(String.format("%s with %s %s not found.", clazz.getName(), by, searchString));
    }

    public EntityNotFoundException(Class clazz, Long objectId) {
        this(clazz, "objectId", objectId.toString());
    }
}
