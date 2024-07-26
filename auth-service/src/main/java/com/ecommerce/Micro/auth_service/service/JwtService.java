package com.ecommerce.Micro.auth_service.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtService {

    String extractUsername(String token);

    Date extractExpiration(String token);

    <T> T extractClaims(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserDetails userDetails);

    Boolean validateToken(String Token, UserDetails userDetail);




}
