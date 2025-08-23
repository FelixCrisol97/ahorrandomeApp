package com.crisol.ahorrandome.exception.dto.user;

import java.time.LocalDateTime;

import com.crisol.ahorrandome.dto.user.UserInfo;
import com.crisol.ahorrandome.exception.ErrorType;

public class UserNotFoundException extends RuntimeException {

    private final ErrorType errorType;
    private final LocalDateTime timestamp;
    private final UserInfo user;

    public UserNotFoundException(String message,ErrorType errorType, UserInfo user) {
        super(message);
        this.errorType = errorType;
        this.timestamp = LocalDateTime.now();
        this.user = user;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public UserInfo getUser() {
        return user;
    }

}
