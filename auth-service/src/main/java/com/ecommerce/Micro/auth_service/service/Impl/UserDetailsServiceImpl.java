package com.ecommerce.Micro.auth_service.service.Impl;

import com.ecommerce.Micro.auth_service.Client.CustomerClient;
import com.ecommerce.Micro.auth_service.model.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {
    private final CustomerClient customerClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(customerClient.getByUsername(username).getBody());
    }
}
