package com.omni.stock.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Stock {
    @Id
    private String id;
    private String code;
    private long quantity;

    public Stock(String id, String code, long quantity) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
    }
}