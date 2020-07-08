package com.fidecoin.billingservice.repository;

import com.fidecoin.billingservice.entities.Bill;
import com.fidecoin.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
