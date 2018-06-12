package com.xpeppers.payments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PaymentsService {
    private final List<Payment> payments = new ArrayList<>();
    private EventPublisher eventPublisher;

    public PaymentsService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public boolean receivedFor(UUID orderId) {
        Date paymentDate = new Date();

        eventPublisher.publish(new OrderPaidEvent(orderId, paymentDate));

        if (orderPaid(orderId) && prepareShippingFor(orderId)) {
            payments.add(new Payment(orderId, paymentDate));
            return true;
        }

        return false;
    }

    public List<Payment> allPayments() {
        return new ArrayList<>(payments);
    }

    private boolean orderPaid(UUID orderId) {
        /*TODO: implement me*/
        return true;
    }

    private boolean prepareShippingFor(UUID orderId) {
        /*TODO: implement me*/
        return true;
    }
}
