package com.backend.SocialMediaBackend.api.services;


import com.backend.SocialMediaBackend.api.exception.UserAlreadyExistsException;
import com.backend.SocialMediaBackend.api.model.LoginUserBody;
import com.backend.SocialMediaBackend.api.model.RegisterUser;
import com.backend.SocialMediaBackend.api.repository.UserRepository;
import com.backend.SocialMediaBackend.api.security.JwtUtil;
import com.backend.SocialMediaBackend.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LocalUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public void registerBody(RegisterUser registerUser) throws UserAlreadyExistsException {

        if(userRepository.findByEmailIgnoreCase(registerUser.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        LocalUser localUser = new LocalUser();
        System.out.println("Email : " + registerUser.getEmail() +" email");
        localUser.setEmail(registerUser.getEmail());
        localUser.setName(registerUser.getName());
        localUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));

//        String base64Image = Base64.getEncoder().encodeToString(profilePicture.getBytes());
//        localUser.setProfilePicture(base64Image);
        userRepository.save(localUser);
    }

    public String signin(LoginUserBody loginUserBody) {
        LocalUser localUser = userRepository.findByEmailIgnoreCase(loginUserBody.getEmail()).orElseThrow(
                () -> new RuntimeException("Invalid Credentials !")
        );


        if (!passwordEncoder.matches(loginUserBody.getPassword(), localUser.getPassword())) {
            throw new RuntimeException("Invalid Credentials!");
        }
        return jwtUtil.generateJwt(localUser.getEmail());

    }
}