package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class ProductRecord implements Product, Record{
    private int id;
    private String name;
    private String description;
    private float price;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("id", id);
            put("uri", routes.productUri(ProductRecord.this));
            put("name", name);
            put("description", description);
            put("price", price);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}
