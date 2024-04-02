package com.riya.EcommerceApplicationBackend.api.services;


import com.riya.EcommerceApplicationBackend.api.repo.WebOrderRepository;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import com.riya.EcommerceApplicationBackend.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebOrderService {

    @Autowired
    private WebOrderRepository webOrderRepository;

    public List<WebOrder> getOrders(LocalUser user) {
        return webOrderRepository.findByUser(user);
    }
}
