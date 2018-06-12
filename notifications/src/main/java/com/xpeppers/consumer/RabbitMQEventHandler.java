package com.xpeppers.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

class RabbitMQEventHandler implements EventHandler {
    public static final int FIVE_SECONDS = 5000;
    private static final String EXCHANGE_NAME = "events";

    private String host;

    RabbitMQEventHandler(String host) {
        this.host = host;
    }

    @Override
    public void start() {
        waitForNewEvents();
    }

    private void waitForNewEvents() {
        try {
            Thread.sleep(FIVE_SECONDS);

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(this.host);
            Connection connection = factory.newConnection();

            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, EXCHANGE_NAME, "");

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            channel.basicConsume(queueName, true, new RabbitMQEventConsumer(channel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
