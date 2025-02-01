package com.printers.exception;


public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(Long id) {
        super("Unable to get Details related Id :" + id);
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
