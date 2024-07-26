package com.ecommerce.Micro.auth_service.service.Impl;

import com.ecommerce.Micro.auth_service.dto.authentication.AuthenticationRequest;
import com.ecommerce.Micro.auth_service.dto.authentication.AuthenticationResponse;
import com.ecommerce.Micro.auth_service.service.AuthenticationService;
import com.ecommerce.Micro.auth_service.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp  implements AuthenticationService{

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @Override
    public AuthenticationService authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )

            );

        } catch (BadCredentialsException e) {
            throw new RuntimeException(" BAd credentials ");

        }

        return new AuthenticationResponse(jwtService.generateToken(userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername())));
    }
}
