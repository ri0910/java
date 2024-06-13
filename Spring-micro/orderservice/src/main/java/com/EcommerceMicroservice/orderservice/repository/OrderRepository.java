package com.EcommerceMicroservice.orderservice.repository;

import com.EcommerceMicroservice.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
