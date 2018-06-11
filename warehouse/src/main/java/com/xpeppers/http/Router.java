package com.xpeppers.http;

import com.xpeppers.warehouse.Warehouse;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        WarehouseController WarehouseController = new WarehouseController(warehouse);

        port(8181);
        post("/pickProducts", WarehouseController::create);
        get("/reservedProducts", WarehouseController::list);
    }
}
