package com.riya.JobSecurityWebsite.service;


import com.riya.JobSecurityWebsite.model.User;
import com.riya.JobSecurityWebsite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo repo;


    public void addUser(User user) {
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setConfirmPassword(encoder.encode(user.getConfirmPassword()));
        user.setRole(user.getRole());
        repo.save(user);
    }

    public User getUser(Integer id) {
        return repo.findById(id).get();
    }

    public List<User> viewUsers() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userinfo = Optional.ofNullable(repo.findByUsername(username));
        return userinfo.map(UserInfoDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
    }

    public User getUserByName(String username) {
        return repo.findByUsername(username);
    }
}
