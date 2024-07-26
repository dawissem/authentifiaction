package com.ecommerce.Micro.auth_service.Client;

import com.ecommerce.Micro.auth_service.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER",url ="https://localhost:8085/api/v1/customers")
public interface CustomerClient {
    @GetMapping("/username/{username}")
    ResponseEntity<CustomerResponse> getByUsername(@PathVariable("username") String username);

}

