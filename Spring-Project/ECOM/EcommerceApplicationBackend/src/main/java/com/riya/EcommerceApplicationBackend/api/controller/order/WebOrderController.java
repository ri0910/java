package com.riya.EcommerceApplicationBackend.api.controller.order;


import com.riya.EcommerceApplicationBackend.api.services.WebOrderService;
import com.riya.EcommerceApplicationBackend.model.LocalUser;
import com.riya.EcommerceApplicationBackend.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class WebOrderController {

    @Autowired
    private WebOrderService webOrderService;

    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal LocalUser user) {
        return  webOrderService.getOrders(user);
    }
}
