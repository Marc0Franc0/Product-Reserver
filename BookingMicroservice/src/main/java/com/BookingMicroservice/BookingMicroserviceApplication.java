package com.BookingMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.retry.annotation.CircuitBreaker;

@SpringBootApplication
//Anotación necesaria para que se registre dentro del EurekaServer
@EnableDiscoveryClient
@EnableFeignClients
@CircuitBreaker
public class BookingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMicroserviceApplication.class, args);
	}

}
