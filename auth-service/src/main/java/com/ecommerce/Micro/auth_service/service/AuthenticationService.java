package com.ecommerce.Micro.auth_service.service;

import com.ecommerce.Micro.auth_service.dto.authentication.AuthenticationRequest;

public interface AuthenticationService {

    AuthenticationService authenticate (AuthenticationRequest authenticationRequest);

}
