package com.crisol.ahorrandome.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisol.ahorrandome.model.user.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByName(String name);


}
