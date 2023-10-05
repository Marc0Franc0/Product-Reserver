package com.StockMicroservice.service;

import com.StockMicroservice.model.Stock;
import com.StockMicroservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    public Optional<Stock> stockAvailable(String code){
        Optional<Stock> stock = stockRepository.findByCode(code);
           return stock;
    }
}
