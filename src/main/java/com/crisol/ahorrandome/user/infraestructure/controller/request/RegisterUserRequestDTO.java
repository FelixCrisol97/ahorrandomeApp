package com.crisol.ahorrandome.user.infraestructure.controller.request;

public class RegisterUserRequestDTO {
    private String email;
    private String password;

    // Getters y setters para que Spring lo pueda mapear
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
