package com.example.chat.entiy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;

    // Getters and setters

    @Override
    public String toString() {
        return "LoginRequest [username=" + username + ", password=" + password + "]";
    }
}

