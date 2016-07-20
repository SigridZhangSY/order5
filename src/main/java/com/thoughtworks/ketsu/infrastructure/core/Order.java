package com.thoughtworks.ketsu.infrastructure.core;

import com.thoughtworks.ketsu.infrastructure.records.OrderItemRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public interface Order {
    long getId();
    int getUserId();
    String getName();
    String getAddress();
    String getPhone();
    float getTotalPrice();
    Date getTime();
    List<OrderItemRecord> getItems();
    Payment createPayment(Map<String, Object> info);
}
