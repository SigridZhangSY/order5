package com.thoughtworks.ketsu.infrastructure.core;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface User {
    int getId();
    String getName();

    Order createOrderForUser(Map<String, Object> info);

    List<Order> listOrdersForUser();

    Optional<Order> findOrderById(long orderId);
}
