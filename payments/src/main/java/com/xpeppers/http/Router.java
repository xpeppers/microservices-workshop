package com.xpeppers.http;

import com.xpeppers.payments.PaymentsService;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        PaymentsService paymentsService = new PaymentsService();
        PaymentsController paymentsController = new PaymentsController(paymentsService);

        port(8282);
        post("/payments", paymentsController::create);
        get("/payments", paymentsController::list);
    }
}
