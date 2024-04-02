package com.riya.EcommerceApplicationBackend.api.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/products", "/auth/register", "/auth/login").permitAll()
                .anyRequest().authenticated());
        return http.build();
    }
}
