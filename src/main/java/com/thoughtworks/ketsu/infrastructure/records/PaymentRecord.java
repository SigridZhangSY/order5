package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Payment;

import java.util.Date;

/**
 * Created by syzhang on 7/20/16.
 */
public class PaymentRecord implements Payment{
    private long orderId;
    private String payType;
    private float amount;
    Date time;

    public PaymentRecord(long orderId){
        this.orderId = orderId;
    }

    public PaymentRecord(){
    }

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
}
