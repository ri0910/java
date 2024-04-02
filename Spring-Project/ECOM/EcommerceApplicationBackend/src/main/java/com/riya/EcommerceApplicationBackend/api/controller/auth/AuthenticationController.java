package com.riya.EcommerceApplicationBackend.api.controller.auth;


import com.riya.EcommerceApplicationBackend.api.exception.UserAlreadyExistsException;
import com.riya.EcommerceApplicationBackend.api.model.LocalResponse;
import com.riya.EcommerceApplicationBackend.api.model.LoginUserBody;
import com.riya.EcommerceApplicationBackend.api.model.RegistrationBody;
import com.riya.EcommerceApplicationBackend.api.services.UserService;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegistrationBody registrationBody){
        try{
            userService.registerBody(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LocalResponse> loginUSer(@Valid @RequestBody LoginUserBody loginUserBody) {
        String jwt = userService.loginUser(loginUserBody);

        if(jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            LocalResponse localResponse = new LocalResponse();
            localResponse.setJwt(jwt);
            return ResponseEntity.ok(localResponse);
        }
    }

    @GetMapping("/me")
    public LocalUser getProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }

}
