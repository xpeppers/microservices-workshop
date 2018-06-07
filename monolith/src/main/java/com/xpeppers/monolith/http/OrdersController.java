package com.xpeppers.monolith.http;

import com.xpeppers.monolith.warehouse.Warehouse;
import spark.Request;
import spark.Response;

class OrdersController {
    private final Warehouse warehouse;

    OrdersController(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    String handle(Request request, Response response) {
        String productCode = request.queryParams("product_code");
        Integer productQuantity = Integer.valueOf(request.queryParams("product_quantity"));

        if (warehouse.isAvailable(productCode, productQuantity)) {
            return "order confirmed";
        }

        return "product not available";
    }
}
