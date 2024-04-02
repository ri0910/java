package com.riya.EcommerceApplicationBackend.api.services;


import com.riya.EcommerceApplicationBackend.api.exception.EmailFailureException;
import com.riya.EcommerceApplicationBackend.api.exception.UserAlreadyExistsException;
import com.riya.EcommerceApplicationBackend.api.model.LoginUserBody;
import com.riya.EcommerceApplicationBackend.api.model.RegistrationBody;
import com.riya.EcommerceApplicationBackend.api.repo.UserRepository;
import com.riya.EcommerceApplicationBackend.api.repo.VerificationTokenRepository;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import com.riya.EcommerceApplicationBackend.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;


    public void registerBody(RegistrationBody registrationBody) throws UserAlreadyExistsException, EmailFailureException {
        if (repository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || repository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser localUser = new LocalUser();
        localUser.setUsername(registrationBody.getUsername());
        localUser.setEmail(registrationBody.getEmail());
        localUser.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        localUser.setFirstName(registrationBody.getFirstName());
        localUser.setLastName(registrationBody.getLastName());
        VerificationToken verificationToken = createVerificationToken(localUser);
        emailService.sendVerificationEmail(verificationToken);
        repository.save(localUser);
    }

    public VerificationToken createVerificationToken(LocalUser user) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(jwtService.generateVerificationJWT(user));
        verificationToken.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
        verificationToken.setUser(user);
        user.getVerificationToken().add(verificationToken);
        return  verificationToken;
    }

    public String loginUser(LoginUserBody loginUserBody) {
        Optional<LocalUser> opUser = repository.findByUsernameIgnoreCase(loginUserBody.getUsername());
        if(opUser.isPresent()) {
            LocalUser localUser = opUser.get();
            if(encryptionService.verifyPassword(loginUserBody.getPassword(), localUser.getPassword())) {
                return jwtService.generateJwt(localUser);
            }
        }

        return null;
    }
}
