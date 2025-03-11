package com.yvqing.loginregister.handler;

/**
 * UserNotFoundException class.
 *
 * @author Administrator
 * @since 2025/2/12
 */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

