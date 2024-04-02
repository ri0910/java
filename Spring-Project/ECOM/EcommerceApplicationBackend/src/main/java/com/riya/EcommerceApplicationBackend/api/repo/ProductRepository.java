package com.riya.EcommerceApplicationBackend.api.repo;


import com.riya.EcommerceApplicationBackend.model.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {
}
