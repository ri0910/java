package com.riya.EcommerceApplicationBackend.api.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;


    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;


    private static final String USERNAME = "USERNAME";
    private static final String EMAIL_KEY = "EMAIL";

    @PostConstruct
    public void postConstruct() {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    /**
     * Generates a JWT based on the given user.
     * @param user The user to generate for.
     * @return The JWT.
     */

    public String generateJwt(LocalUser localUser){
        return JWT.create()
                .withClaim(USERNAME, localUser.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String generateVerificationJWT(LocalUser user) {
        return JWT.create()
                .withClaim(EMAIL_KEY, user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }


     public String getUsername(String token) {
        return JWT.decode(token)
                .getClaim(USERNAME)
                .asString();
     }
}
