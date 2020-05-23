package com.omni.stock.handlers;

import com.omni.stock.documents.Stock;
import com.omni.stock.services.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockHandler {
    private final StockService stockService;

    public Mono<ServerResponse> findAll(final ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.stockService.findAll(), Stock.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> findOneByCode(final ServerRequest serverRequest) {
        final String code = serverRequest.pathVariable("code");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.stockService.findOneByCode(code), Stock.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> save(final ServerRequest serverRequest) {
        final Mono<Stock> stock = serverRequest.bodyToMono(Stock.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(stock.flatMap(this.stockService::save), Stock.class));
    }
}