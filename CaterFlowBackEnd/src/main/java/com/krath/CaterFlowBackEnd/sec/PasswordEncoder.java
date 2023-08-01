package com.krath.CaterFlowBackEnd.sec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String plainTextPw) {
        return passwordEncoder.encode(plainTextPw);
    }

    public boolean passwordMatch(String plainTextPw, String encodedPw) {
        return passwordEncoder.matches(plainTextPw, encodedPw);
    }
}
