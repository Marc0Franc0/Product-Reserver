package com.BookingMicroservice.service;

import com.BookingMicroservice.dto.OrderDTO;
import com.BookingMicroservice.model.Order;
import com.BookingMicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order create (OrderDTO orderDTO){
        return orderRepository
                .save(
                        new Order(
                                UUID.randomUUID().toString(),
                                orderDTO.getOrderItems()
                        ));
    }
}
