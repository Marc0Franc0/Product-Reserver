package com.BookingMicroservice.controller;

import com.BookingMicroservice.client.StockClient;
import com.BookingMicroservice.dto.OrderDTO;
import com.BookingMicroservice.model.Order;
import com.BookingMicroservice.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private StockClient stockClient;
    @Autowired
    private OrderService orderService;
    @PostMapping("/order")
    //Necesario para circuit breaker
    @HystrixCommand(fallbackMethod = "fallbackToStockService")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO){
        //Se verifica si existe stock por cada item
        boolean inStock = orderDTO.getOrderItems()
                .stream()
                .allMatch((orderItem -> stockClient.stockAvailable(orderItem.getCode())));
        if(inStock){
            return ResponseEntity.status(HttpStatus.OK).body(orderService.create(orderDTO));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Order cannot be saved");
        }

    }

    //Para en caso de error en la implementación se ejecuta el siguiente método
    private String fallbackToStockService(){
        return "Something went wrong, please ty some time";
    }
}
