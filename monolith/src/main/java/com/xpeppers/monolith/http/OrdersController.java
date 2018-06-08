package com.xpeppers.monolith.http;

import com.google.gson.Gson;
import com.xpeppers.monolith.orders.Order;
import com.xpeppers.monolith.orders.OrderRepository;
import com.xpeppers.monolith.warehouse.Warehouse;
import spark.Request;
import spark.Response;

import java.util.UUID;

class OrdersController {
    private final Warehouse warehouse;
    private final OrderRepository orderRepository;

    OrdersController(OrderRepository orderRepository, Warehouse warehouse) {
        this.warehouse = warehouse;
        this.orderRepository = orderRepository;
    }

    String create(Request request, Response response) {
        String productCode = request.queryParams("product_code");
        Integer productQuantity = Integer.valueOf(request.queryParams("product_quantity"));

        if (placeOrderFor(productCode, productQuantity)) {
            return "order reserved";
        }

        return "order placed";
    }

    private boolean placeOrderFor(String productCode, Integer productQuantity) {
        Order order = new Order(UUID.randomUUID(), productCode, productQuantity);
        orderRepository.add(order);

        if (warehouse.pickProducts(order.id(), productCode, productQuantity)) {
            order.reserved();
            orderRepository.update(order);
            return true;
        }

        return false;
    }

    String list(Request request, Response response) {
        return new Gson()
                .toJson(orderRepository.all());
    }
}
