package com.BookingMicroservice.dto;

import com.BookingMicroservice.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private List<OrderItem> orderItems;
}
