package com.xpeppers.http;

import com.xpeppers.payments.EventPublisher;
import com.xpeppers.payments.PaymentsService;
import com.xpeppers.payments.RabbitMQEventPublisher;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        String rabbitMqHost = System.getenv("RABBITMQ_HOST");

        EventPublisher eventPublisher = new RabbitMQEventPublisher(rabbitMqHost);
        PaymentsService paymentsService = new PaymentsService(eventPublisher);

        PaymentsController paymentsController = new PaymentsController(paymentsService);

        port(8282);
        post("/payments", paymentsController::create);
        get("/payments", paymentsController::list);
    }
}
