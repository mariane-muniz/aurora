package com.omni.function.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class ValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationApplication.class, args);
    }

    @Bean
    public Function<Flux<String>, Flux<String>> toUpperCase() {
        return stringFlux -> stringFlux.map(String::toUpperCase);
    }
}