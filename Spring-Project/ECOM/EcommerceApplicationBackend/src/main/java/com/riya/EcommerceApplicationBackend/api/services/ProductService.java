package com.riya.EcommerceApplicationBackend.api.services;


import com.riya.EcommerceApplicationBackend.api.repo.ProductRepository;
import com.riya.EcommerceApplicationBackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}
