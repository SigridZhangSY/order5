package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public class OrderRecord implements Order, Record {
    private long id;
    private int userId;
    private String name;
    private String address;
    private String phone;
    private float totalPrice;
    private Date time;
    private List<OrderItemRecord> items;

    public OrderRecord(long id, int userId){
        this.id = id;
        this.userId = userId;
    }

    public OrderRecord(){

    }

    @Override
    public long getId() {return id;}

    @Override
    public int getUserId() {return userId;}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public List<OrderItemRecord> getItems() {
        return items;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", routes.orderUri(OrderRecord.this));
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("total_price", totalPrice);
            put("create_at", time);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}
