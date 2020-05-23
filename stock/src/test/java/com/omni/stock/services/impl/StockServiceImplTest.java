package com.omni.stock.services.impl;

import com.omni.stock.documents.Stock;
import com.omni.stock.services.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = StockService.class)

class StockServiceImplTest {

    @Autowired
    private StockService stockService;

    @Test
    void findAll() {
        Assertions.assertNotNull(stockService.findAll());
    }

    @Test
    void findOneByCode() {

    }

    @Test
    void save() {
//        final Stock s = new Stock(UUID.randomUUID().toString(), "999", 1);
//        stockService.save(null);
    }
}