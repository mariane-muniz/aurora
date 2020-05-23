package com.omni.stock.services;

import com.omni.stock.documents.Stock;
import com.omni.stock.repositories.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Service
//@Slf4j
//@AllArgsConstructor
//public class StockDummyData implements CommandLineRunner {
//
//    private final StockRepository stockRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Stock> stocks = new ArrayList<>();
//        stocks.add(new Stock(UUID.randomUUID().toString(), "12345", 3));
//        stocks.add(new Stock(UUID.randomUUID().toString(), "1A345", 0));
//        stocks.add(new Stock(UUID.randomUUID().toString(), "123D5", 5));
//        stocks.add(new Stock(UUID.randomUUID().toString(), "123X5", 9));
//        stocks.add(new Stock(UUID.randomUUID().toString(), "123P5", 12));
//        this.stockRepository.deleteAll().thenMany(
//                Flux.just(stocks)
//                        .flatMap(this.stockRepository::saveAll)
//        ).subscribe(subs -> log.info(subs.getCode()));
//    }
//}