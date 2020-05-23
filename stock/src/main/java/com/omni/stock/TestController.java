package com.omni.stock;

import com.omni.stock.documents.Stock;
import com.omni.stock.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final StockService stockService;

    @GetMapping(value = "/stock-events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Stock>> events() {
        final Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        final Flux<Stock> events = this.stockService.findAll();
        return Flux.zip(interval, events);
    }
}