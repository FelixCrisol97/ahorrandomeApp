package com.crisol.ahorrandome.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crisol.ahorrandome.dto.user.UserInfo;
import com.crisol.ahorrandome.exception.ErrorType;
import com.crisol.ahorrandome.exception.user.UserNotFoundException;
import com.crisol.ahorrandome.model.user.User;
import com.crisol.ahorrandome.repository.user.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(User user) {
        return userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + user.getId(),
                        ErrorType.USER_NOT_FOUND, new UserInfo(user.getId(), user.getName(), user.getEmail())));
    }

    public void deleteById(User user) {
        userRepository.deleteById(user.getId());
    }

    public User findByUsername(User user) {
        return userRepository.findByName(user.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found with username " + user.getName(),
                        ErrorType.USER_NOT_FOUND, new UserInfo(user.getId(), user.getName(), user.getEmail())));
    }

}
