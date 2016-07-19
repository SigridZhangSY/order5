package com.thoughtworks.ketsu.infrastructure.core;


import java.util.List;
import java.util.Map;

public interface ProductRepository {
    Product createProduct(Map<String, Object> info);

    List<Product> lisAllProducts();
}
