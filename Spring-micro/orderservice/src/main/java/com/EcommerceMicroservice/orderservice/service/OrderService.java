package com.EcommerceMicroservice.orderservice.service;

import com.EcommerceMicroservice.orderservice.dto.OrderLineItemsDto;
import com.EcommerceMicroservice.orderservice.dto.OrderRequest;
import com.EcommerceMicroservice.orderservice.model.Order;
import com.EcommerceMicroservice.orderservice.model.OrderLineItems;
import com.EcommerceMicroservice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderNumberListListdto()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderNumberListList(orderLineItemsList);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
