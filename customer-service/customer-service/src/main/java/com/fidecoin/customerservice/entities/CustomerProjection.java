package com.fidecoin.customerservice.entities;

import com.fidecoin.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.lang.reflect.Type;

@Projection(name = "p1", types = Customer.class)
interface CustomerProjection {
    public Long getId();
    public String getName();
}
