package com.xpeppers.consumer;

public class Main {
    public static void main(String[] argv) {
        String rabbitMqHost = System.getenv("RABBITMQ_HOST");
        EventHandler eventHandler = new RabbitMQEventHandler(rabbitMqHost);

        eventHandler.start();
    }
}
