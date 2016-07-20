package com.thoughtworks.ketsu.infrastructure.core;


import java.util.Map;

public interface User {
    int getId();
    String getName();

    Order createOrderForUser(Map<String, Object> info);
}
