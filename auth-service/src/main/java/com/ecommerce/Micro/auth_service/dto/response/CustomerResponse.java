package com.ecommerce.Micro.auth_service.dto.response;

import com.ecommerce.Micro.auth_service.enums.CustomerRole;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class CustomerResponse {


    private Long id;
    private String username;
    private String password;
    private CustomerRole role;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
