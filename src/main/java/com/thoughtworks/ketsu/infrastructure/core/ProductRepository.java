package com.thoughtworks.ketsu.infrastructure.core;


import java.util.Map;

public interface ProductRepository {
    Product createProduct(Map<String, Object> info);
}
