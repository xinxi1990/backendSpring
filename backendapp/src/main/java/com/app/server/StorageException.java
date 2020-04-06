package com.app.server;

public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
        System.out.println(message);

    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}