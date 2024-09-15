package com.backend.SocialMediaBackend.api.controller;

import com.backend.SocialMediaBackend.api.exception.UserAlreadyExistsException;
import com.backend.SocialMediaBackend.api.model.LocalUserResponseBody;
import com.backend.SocialMediaBackend.api.model.LoginUserBody;
import com.backend.SocialMediaBackend.api.model.RegisterUser;
import com.backend.SocialMediaBackend.api.services.LocalUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private LocalUserService localUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUser registrationBody){
        try{
            localUserService.registerBody(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            logger.warn("User already exists: {}", registrationBody.getEmail());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<LocalUserResponseBody> signin(@RequestBody @Valid LoginUserBody loginUserBody) {
        try {
            LocalUserResponseBody localUserResponseBody = new LocalUserResponseBody();
            String token = localUserService.signin(loginUserBody);
            localUserResponseBody.setId(loginUserBody.getId());
            localUserResponseBody.setEmail(loginUserBody.getEmail());
            localUserResponseBody.setToken(token);
            return ResponseEntity.ok(localUserResponseBody);
        } catch (RuntimeException ex) {
            logger.warn("Invalid credentials : " + loginUserBody.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
