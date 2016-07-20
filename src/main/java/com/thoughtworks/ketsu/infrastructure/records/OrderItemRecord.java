package com.thoughtworks.ketsu.infrastructure.records;

/**
 * Created by syzhang on 7/20/16.
 */
public class OrderItemRecord implements com.thoughtworks.ketsu.infrastructure.core.OrderItem {
    private int productId;
    private int quantity;
    private float amount;

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
