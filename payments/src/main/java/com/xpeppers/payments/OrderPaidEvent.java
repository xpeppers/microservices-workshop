package com.xpeppers.payments;

import java.util.Date;
import java.util.UUID;

public class OrderPaidEvent {
    private final UUID orderId;
    private final Date paymentDate;

    public OrderPaidEvent(UUID orderId, Date paymentDate) {
        this.orderId = orderId;
        this.paymentDate = paymentDate;
    }
}
