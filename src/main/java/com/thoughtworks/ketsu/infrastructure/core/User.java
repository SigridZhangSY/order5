package com.thoughtworks.ketsu.infrastructure.core;


public interface User {
    int getId();
    String getName();

    Order createOrderForUser(int userId, long orderId);
}
