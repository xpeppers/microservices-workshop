package com.xpeppers.http;

import com.google.gson.Gson;
import com.xpeppers.warehouse.Warehouse;
import spark.Request;
import spark.Response;

import java.util.UUID;

class WarehouseController {
    private final Warehouse warehouse;

    WarehouseController(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    String create(Request request, Response response) {
        UUID orderId = UUID.fromString(request.queryParams("order_id"));
        String productCode = request.queryParams("product_code");
        Integer productQuantity = Integer.valueOf(request.queryParams("product_quantity"));

        if (warehouse.pickProducts(orderId, productCode, productQuantity)) {
            response.status(201);
            return "products reserved";
        }

        response.status(406);
        return "products not available";
    }

    String list(Request request, Response response) {
        return new Gson()
                .toJson(warehouse.allReservedProducts());
    }
}
