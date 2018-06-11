package com.xpeppers.warehouse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.UUID;

public class Warehouse {
    public boolean pickProducts(UUID orderId, String productCode, Integer productQuantity) {
        try {
            return reserveProductsFor(orderId, productCode, productQuantity);
        } catch (UnirestException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean reserveProductsFor(UUID orderId, String productCode, Integer productQuantity) throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:8181/pickProducts")
                .field("order_id", orderId)
                .field("product_code", productCode)
                .field("product_quantity", productQuantity)
                .asString();

        return response.getStatus() == 201;
    }
}
