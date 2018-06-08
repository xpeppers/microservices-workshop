package com.xpeppers.monolith.orders;

import java.util.UUID;

public class Order {
    private final UUID id;
    private final String productCode;
    private final Integer productQuantity;

    public Order(UUID id, String productCode, Integer productQuantity) {
        this.id = id;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
    }
}
