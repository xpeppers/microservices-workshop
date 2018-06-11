package com.xpeppers.payments;

import java.util.Date;
import java.util.UUID;

public class Payment {
    private final UUID orderId;
    private final Date date;

    public Payment(UUID orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
    }
}
