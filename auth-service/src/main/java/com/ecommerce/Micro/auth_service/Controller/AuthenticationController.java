package com.ecommerce.Micro.auth_service.Controller;

import com.ecommerce.Micro.auth_service.dto.authentication.AuthenticationRequest;
import com.ecommerce.Micro.auth_service.dto.authentication.AuthenticationResponse;
import com.ecommerce.Micro.auth_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest authenticationRequest){
      return ResponseEntity.ok((AuthenticationResponse) authenticationService.authenticate(authenticationRequest));
  }

}
