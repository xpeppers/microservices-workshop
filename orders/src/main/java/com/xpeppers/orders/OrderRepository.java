package com.xpeppers.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> all() {
        return orders;
    }

    public void update(Order order) {
        Order storedOrder = findById(order.id);

        if (storedOrder != null) {
            orders.remove(storedOrder);
            orders.add(order);
        }
    }

    private Order findById(UUID id) {
        return orders.stream()
                .filter(currentOrder -> currentOrder.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
