package com.xpeppers.monolith.warehouse;

import java.util.*;

public class Warehouse {
    private static final Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("111", 1);
        put("222", 2);
        put("333", 3);
        put("444", 4);
        put("555", 5);
    }};

    private static final List<ReservedProduct> reservedProcucts = new ArrayList<>();

    public boolean pickProducts(UUID orderId, String productCode, Integer productQuantity) {
        if (isAvailable(productCode, productQuantity)) {
            reserveFor(orderId, productCode, productQuantity);
            return true;
        }
        return false;
    }

    private void reserveFor(UUID orderId, String productCode, Integer productQuantity) {
        int updatedProductInventory = products.get(productCode) - productQuantity;
        products.put(productCode, updatedProductInventory);
        reservedProcucts.add(new ReservedProduct(orderId, productCode, productQuantity));
    }

    private boolean isAvailable(String productCode, Integer productQuantity) {
        return products.get(productCode) >= productQuantity;
    }
}
