package com.ecommerce.Micro.auth_service.model;

import com.ecommerce.Micro.auth_service.dto.response.CustomerResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {


    private final CustomerResponse customerResponse;

    public UserDetailsImpl(CustomerResponse customerResponse) {
        this.customerResponse = customerResponse;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((new  SimpleGrantedAuthority(customerResponse.getRole().name())));
    }

    @Override
    public String getPassword() {
        return customerResponse.getPassword();
    }

    @Override
    public String getUsername() {
        return customerResponse.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
