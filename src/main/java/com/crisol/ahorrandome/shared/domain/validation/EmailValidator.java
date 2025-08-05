package com.crisol.ahorrandome.shared.domain.validation;



public class EmailValidator {
    

    private EmailValidator(){}

    public static boolean isValid(String email){
        if(email == null || email.trim().isEmpty()) return false;
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

}
