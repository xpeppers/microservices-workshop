package com.xpeppers.http;

import com.google.gson.Gson;
import com.xpeppers.payments.PaymentsService;
import spark.Request;
import spark.Response;

import java.util.UUID;

class PaymentsController {
    private PaymentsService paymentsService;

    PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    String create(Request request, Response response) {
        UUID orderId = UUID.fromString(request.queryParams("order_id"));

        if (paymentsService.receivedFor(orderId)) {
            response.status(201);
            return "payment received for order: " + orderId;
        }

        response.status(406);
        return "unable to close payment for order: " + orderId;
    }

    String list(Request request, Response response) {
        return new Gson()
                .toJson(paymentsService.allPayments());
    }
}
