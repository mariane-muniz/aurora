package com.omni.stock.routers;

import com.omni.stock.handlers.StockHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class StockRouter {

    @Bean
    public RouterFunction<ServerResponse> route(final StockHandler stockHandler) {
        return RouterFunctions
                .route(GET("/stock").and(accept(MediaType.APPLICATION_JSON)), stockHandler::findAll)
                .andRoute(GET("/stock/{code}").and(accept(MediaType.APPLICATION_JSON)), stockHandler::findOneByCode)
                .andRoute(POST("/stock").and(accept(MediaType.APPLICATION_JSON)), stockHandler::save);
    }
}