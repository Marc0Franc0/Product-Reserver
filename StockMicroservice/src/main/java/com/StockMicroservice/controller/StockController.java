package com.StockMicroservice.controller;

import com.StockMicroservice.model.Stock;
import com.StockMicroservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    //Utilizado en metodo stockAvailable
    boolean inStock = false;
    @Autowired
    private StockService stockService;
    @GetMapping("/{code}")
    public ResponseEntity<?> stockAvailable(@PathVariable String code){
        //Utilización de servicio
        Optional<?> stock = stockService.stockAvailable(code);
        //Verificacón de dato optional
        stock.ifPresentOrElse(
                (s)-> inStock = true,
                        ()-> inStock = false );
        //Retorno de método dependiendo de disponibilidad de stock
        if(inStock){
            return ResponseEntity.status(HttpStatus.OK).body(stock.get());
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not found "+code);
        }
    }
}
