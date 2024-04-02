package com.riya.EcommerceApplicationBackend.api.services;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


/**
 * Service for handling encryption of passwords.
 */

@Service
public class EncryptionService {

    @Value("${encryption.salt.rounds}")
    private int saltRounds;

    private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRounds);
    }

    /**
     * Encrypts the given password.
     * @param password The plain text password.
     * @return The encrypted password.
     */

    public String encryptPassword(String password){
        return BCrypt.hashpw(password, salt);
    }

    public boolean verifyPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

}
