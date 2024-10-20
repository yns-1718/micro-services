package org.sid.bilingservice.services;

import org.sid.bilingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")

public interface CustomerRestClient {
    @GetMapping(path="/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
