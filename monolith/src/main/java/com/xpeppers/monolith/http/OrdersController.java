package com.xpeppers.monolith.http;

import com.google.gson.Gson;
import com.xpeppers.monolith.Order;
import com.xpeppers.monolith.persistency.OrderRepository;
import com.xpeppers.monolith.warehouse.Warehouse;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.UUID;

class OrdersController {
    private final Warehouse warehouse;
    private final OrderRepository orderRepository;

    OrdersController(Warehouse warehouse, OrderRepository orderRepository) {
        this.warehouse = warehouse;
        this.orderRepository = orderRepository;
    }

    String create(Request request, Response response) {
        String productCode = request.queryParams("product_code");
        Integer productQuantity = Integer.valueOf(request.queryParams("product_quantity"));

        if (warehouse.isAvailable(productCode, productQuantity)) {
            Order order = new Order(UUID.randomUUID(), productCode, productQuantity);
            orderRepository.confirmed(order);
            warehouse.pickProducts(productCode, productQuantity);
            return "order confirmed";
        }

        return "product not available";
    }

    String list(Request request, Response response) {
        List<Order> orders = orderRepository.all();
        return new Gson().toJson(orders);
    }
}
