package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by syzhang on 7/20/16.
 */
public class OrderRecord implements Order {
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
}
