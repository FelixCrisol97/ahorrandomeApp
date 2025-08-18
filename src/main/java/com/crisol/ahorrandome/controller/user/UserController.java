package com.crisol.ahorrandome.controller.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crisol.ahorrandome.dto.api.response.ApiResponse;
import com.crisol.ahorrandome.model.user.User;
import com.crisol.ahorrandome.service.user.UserService;


/**
 * Controlador REST para manejar operaciones CRUD sobre usuarios.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ------------------- LISTAR TODOS LOS USUARIOS -------------------
    /**
     * Obtiene la lista de todos los usuarios.  
     * @return ResponseEntity con la lista de usuarios y estado HTTP 200 OK.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.findAll();

        ApiResponse<List<User>> data = ApiResponse.success(users);

        return ResponseEntity.ok(data);
    }

    // ------------------- OBTENER USUARIO POR ID -------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<User>>> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        ApiResponse<List<User>> data = ApiResponse.success(List.of(user));
        
        return ResponseEntity.ok(data);
    }

    // ------------------- CREAR NUEVO USUARIO -------------------
    @PostMapping
    public ResponseEntity<ApiResponse<List<User>>> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);

        ApiResponse<List<User>> data = ApiResponse.created(List.of(savedUser));

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    // ------------------- ACTUALIZAR USUARIO EXISTENTE -------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<List<User>>> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Aseguramos que el ID del path y el del body coincidan
        user.setId(id);
        
        User updatedUser = userService.save(user);

        ApiResponse<List<User>> data = ApiResponse.success(List.of(updatedUser));

        return ResponseEntity.ok(data);
    }

    // ------------------- ELIMINAR USUARIO -------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<User>>> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        
        ApiResponse<List<User>> data = ApiResponse.success(List.of(new User(id)));

        return ResponseEntity.ok(data);
    }
}