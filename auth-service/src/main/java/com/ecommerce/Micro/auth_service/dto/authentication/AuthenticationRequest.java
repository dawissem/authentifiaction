package com.ecommerce.Micro.auth_service.dto.authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
private String username;
private String password;
}
