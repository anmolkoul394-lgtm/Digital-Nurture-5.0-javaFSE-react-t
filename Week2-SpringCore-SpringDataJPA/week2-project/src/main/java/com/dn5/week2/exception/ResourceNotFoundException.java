package com.dn5.week2.exception;

/**
 * Module 5 -> "Spring MVC and ORM" subtopic: "Exception Handling".
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
