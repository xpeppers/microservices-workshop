package com.xpeppers.monolith.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("1111", 1);
        put("2222", 2);
        put("3333", 3);
        put("4444", 4);
        put("5555", 5);
    }};

    public boolean isAvailable(String productCode, Integer productQuantity) {
        return products.get(productCode) >= productQuantity;
    }

    public void pickProducts(String productCode, Integer productQuantity) {
        int updatedProductInventory = products.get(productCode) - productQuantity;
        products.put(productCode, updatedProductInventory);
    }
}
