package com.xpeppers.monolith.warehouse;

import java.util.UUID;

public class ReservedProduct {
    private final UUID orderId;
    private final String code;
    private final Integer quantity;

    public ReservedProduct(UUID orderId, String code, Integer quantity) {
        this.orderId = orderId;
        this.code = code;
        this.quantity = quantity;
    }
}
