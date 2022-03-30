package com.amsdams.error;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Cannot find task with given id");
    }

}