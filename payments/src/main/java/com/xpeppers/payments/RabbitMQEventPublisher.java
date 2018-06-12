package com.xpeppers.payments;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQEventPublisher implements EventPublisher {
    private static final String EXCHANGE_NAME = "events";
    private String host;

    public RabbitMQEventPublisher(String host) {
        this.host = host;
    }

    @Override
    public void publish(OrderPaidEvent orderPaidEvent) {
        sendMessage();
    }

    private void sendMessage() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(this.host);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

            byte[] message = "hello world".getBytes("UTF-8");

            channel.basicPublish(EXCHANGE_NAME, "", null, message);

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
