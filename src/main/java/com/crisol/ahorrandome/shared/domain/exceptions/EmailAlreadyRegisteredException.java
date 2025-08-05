package com.crisol.ahorrandome.shared.domain.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException{
    
    public EmailAlreadyRegisteredException(String email) {
        super("Email already registered: " + email);
    }

}
