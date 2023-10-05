package com.BookingMicroservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order( String orderNo, List<OrderItem> orderItems) {
        this.orderNo = orderNo;
        this.orderItems = orderItems;
    }
}



