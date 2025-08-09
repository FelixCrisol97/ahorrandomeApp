package com.crisol.ahorrandome.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisol.ahorrandome.model.user.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);

}
