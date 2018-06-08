package com.xpeppers.monolith.persistency;

import com.xpeppers.monolith.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public void confirmed(Order order) {
        orders.add(order);
    }

    public List<Order> all() {
        return orders;
    }
}
