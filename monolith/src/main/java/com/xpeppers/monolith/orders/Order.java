package com.xpeppers.monolith.orders;

import java.util.UUID;

public class Order {
    private final UUID id;
    private final String productCode;
    private final Integer productQuantity;
    private String status;

    public Order(UUID id, String productCode, Integer productQuantity) {
        this.id = id;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.status = "created";
    }

    public UUID id() {
        return id;
    }

    public void reserved() {
        status = "reserved";
    }
}
