package com.xpeppers.consumer;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

class RabbitMQEventConsumer extends DefaultConsumer {
    RabbitMQEventConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        Map payload = fromJson(body);

        String orderId = (String) payload.get("orderId");

        System.out.println(" [x] Received '" + payload + "'");
        System.out.println(" [x] Send mail notification for order: '" + orderId + "'");
    }

    private Map fromJson(byte[] body) throws UnsupportedEncodingException {
        return new Gson()
                .fromJson(new String(body, "UTF-8"), Map.class);
    }
}
