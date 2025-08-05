package com.crisol.ahorrandome.user.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crisol.ahorrandome.user.application.RegisterUserUseCase;
import com.crisol.ahorrandome.user.infraestructure.controller.request.RegisterUserRequestDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCase registerUserCase;

    public UserController(RegisterUserUseCase registerUserUseCase){
        this.registerUserCase = registerUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserRequestDTO registerUserRequestDTO) {
        registerUserCase.execute(registerUserRequestDTO.getEmail(), registerUserRequestDTO.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
