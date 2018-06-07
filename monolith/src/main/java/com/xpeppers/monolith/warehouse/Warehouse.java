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

    public boolean isAvailable(String product_code, Integer product_quantity) {
        return products.get(product_code) >= product_quantity;
    }
}
