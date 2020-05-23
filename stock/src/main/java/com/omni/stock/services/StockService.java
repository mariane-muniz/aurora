package com.omni.stock.services;

import com.omni.stock.documents.Stock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockService {
    Flux<Stock> findAll();
    Mono<Stock> findOneByCode(final String code);
    Mono<Stock> save(Stock stock);
}