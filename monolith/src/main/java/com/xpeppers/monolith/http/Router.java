package com.xpeppers.monolith.http;

import com.xpeppers.monolith.orders.Orders;
import com.xpeppers.monolith.warehouse.Warehouse;

import static spark.Spark.get;
import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Orders orders = new Orders();
        OrdersController ordersController = new OrdersController(orders, warehouse);

        post("/orders", ordersController::create);
        get("/orders", ordersController::list);
    }
}
