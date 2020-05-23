package com.omni.stock.repositories;

import com.omni.stock.documents.Stock;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reactor.core.publisher.Mono;

@RepositoryRestResource(collectionResourceRel = "category")
public interface StockRepository extends ReactiveMongoRepository<Stock, String> {
    Mono<Stock> findByCode(final String code);
}