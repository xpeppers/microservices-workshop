package com.xpeppers.payments;

public interface EventPublisher {
    void publish(OrderPaidEvent orderPaidEvent);
}
