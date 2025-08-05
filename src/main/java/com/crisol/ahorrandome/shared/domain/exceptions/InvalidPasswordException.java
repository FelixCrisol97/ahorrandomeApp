package com.crisol.ahorrandome.shared.domain.exceptions;

    public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String password) {
        super("Invalid password: " + password);
    }
}
