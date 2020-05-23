package com.omni.stock.services.impl;

import com.omni.stock.documents.Stock;
import com.omni.stock.repositories.StockRepository;
import com.omni.stock.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Override
    public Flux<Stock> findAll() {
        return this.stockRepository.findAll();
    }

    @Override
    public Mono<Stock> findOneByCode(final String code) {
        return this.stockRepository.findByCode(code);
    }

    @Override
    public Mono<Stock> save(final Stock stock) {
        return this.stockRepository.save(stock);
    }
}