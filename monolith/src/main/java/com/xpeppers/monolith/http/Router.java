package com.xpeppers.monolith.http;

import com.xpeppers.monolith.warehouse.Warehouse;

import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        OrdersController ordersController = new OrdersController(warehouse);

        post("/orders", ordersController::handle);
    }
}
