package com.BookingMicroservice.client;

import com.BookingMicroservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock-microservice",url = "http://api-gateway:8080",configuration = FeignClientConfig.class)
public interface StockClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/stock/{code}")
    public boolean stockAvailable(@PathVariable String code);

}
