package com.crisol.ahorrandome.user.infraestructure.entity;

import java.util.UUID;

import com.crisol.ahorrandome.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    protected UserEntity() {}

    public UserEntity(UUID id, String email, String encryptedPassword) {
        this.id = id;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(
            user.getId(),
            user.getEmail(),
            user.getEncryptedPassword()
        );
    }

    public User toDomain() {
        return new User(
            id,
            email,
            encryptedPassword
        );
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getEncryptedPassword() { return encryptedPassword; }
}
