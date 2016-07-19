package com.thoughtworks.ketsu.support;



import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    private static int auto_increment_key = 1;

    public static Map<String , Object> productMap(String name, String description, float price){
        return new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
            put("price", price);
        }};
    }

}
