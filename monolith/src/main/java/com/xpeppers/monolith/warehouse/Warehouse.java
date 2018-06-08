package com.xpeppers.monolith.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warehouse {
    private static final Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("111", 1);
        put("222", 2);
        put("333", 3);
        put("444", 4);
        put("555", 5);
    }};

    public boolean pickProducts(UUID orderId, String productCode, Integer productQuantity) {
        if (isAvailable(productCode, productQuantity)) {
            pick(productCode, productQuantity);
            return true;
        }
        return false;
    }

    private void pick(String productCode, Integer productQuantity) {
        int updatedProductInventory = products.get(productCode) - productQuantity;
        products.put(productCode, updatedProductInventory);
    }

    private boolean isAvailable(String productCode, Integer productQuantity) {
        return products.get(productCode) >= productQuantity;
    }
}
