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
        String product_code = request.queryParams("product_code");
        String productQuantity = request.queryParams("product_quantity");
        Integer product_quantity = Integer.valueOf(productQuantity);

        if (warehouse.isAvailable(product_code, product_quantity))
            return "order confirmed";

        return "product not available";
    }
}
