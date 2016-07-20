package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public class PaymentRecord implements Payment, Record{
    private long orderId;
    private String payType;
    private float amount;
    Date time;

    @Inject
    OrderMapper orderMapper;

    @Override
    public long getOrderId() {
        return orderId;
    }

    @Override
    public String getPayType() {
        return payType;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        Order order = orderMapper.findById(orderId);
        return new HashMap<String, Object>(){{
            put("order_uri", routes.orderUri(order));
            put("uri", routes.paymentUri(PaymentRecord.this, order.getUserId()));
            put("pay_type", payType);
            put("amount", amount);
            put("create_at", time);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return null;
    }
}
