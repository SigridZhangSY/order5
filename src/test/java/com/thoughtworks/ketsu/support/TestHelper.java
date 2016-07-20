package com.thoughtworks.ketsu.support;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static Map<String , Object> userMap(String name){
        return new HashMap<String, Object>(){{
            put("name", name);
        }};
    }

    public static Map<String , Object> orderMap(String name,int productId){
        return new HashMap<String, Object>(){{
            put("name", name);
            put("address", "beijing");
            put("phone", "12300000000");
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map orderIterm1 = new HashMap<String, Object>();
            orderIterm1.put("product_id", productId);
            orderIterm1.put("quantity", 2);
            list.add(orderIterm1);
            put("order_items", list);
        }};
    }

    public static Map<String , Object> paymentMap(String payType, float amount){
        return new HashMap<String, Object>(){{
            put("pay_type", payType);
            put("amount", amount);
        }};
    }

}
