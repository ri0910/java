package com.riya.EcommerceApplicationBackend.api.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.riya.EcommerceApplicationBackend.api.repo.UserRepository;
import com.riya.EcommerceApplicationBackend.api.services.JwtService;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(7);

            try {

                String username = jwtService.getUsername(token);
                Optional<LocalUser> optuser = userRepository.findByUsernameIgnoreCase(username);

                if(optuser.isPresent()) {
                    LocalUser user = optuser.get();

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            catch ( JWTDecodeException ex){

            }
        }

        filterChain.doFilter(request, response);
    }
}
