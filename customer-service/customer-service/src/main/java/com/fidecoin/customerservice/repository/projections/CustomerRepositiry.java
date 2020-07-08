package com.fidecoin.customerservice.repository.projections;

import com.fidecoin.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepositiry extends JpaRepository<Customer, Long>

{
}
