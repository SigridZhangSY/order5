package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRecord implements User, Record{
    private int id;
    private String name;

    @Inject
    OrderMapper orderMapper;
    @Inject
    ProductMapper productMapper;

    public UserRecord(){
    }

    public UserRecord(int id){
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Order createOrderForUser(Map<String, Object> info) {
        info.put("user_id", id);
        float totalPrice = 0;
        List<Map<String, Object>> items = (List<Map<String, Object>>)info.get("order_items");
        for(int i = 0; i < items.size(); i++){
            Optional<Product> product = Optional.ofNullable(productMapper.findById(Integer.valueOf(String.valueOf(items.get(i).get("product_id")))));
            if (product.isPresent() == false)
                throw new InvalidParameterException("product not exists");
            float amount = product.get().getPrice()*Integer.valueOf(String.valueOf(items.get(i).get("quantity")));
            items.get(i).put("amount", amount);
            totalPrice += amount;
        }

        info.put("total_price", totalPrice);
        orderMapper.save(info);
        return orderMapper.findById(Integer.valueOf(String.valueOf(info.get("id"))));
    }

    @Override
    public List<Order> listOrdersForUser() {
        return orderMapper.getOrdersForUser(id);
    }

    @Override
    public Optional<Order> findOrderById(long orderId) {
        return Optional.ofNullable(orderMapper.findById(orderId));
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("id", id);
            put("uri", routes.userUri(UserRecord.this));
            put("name", name);

        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}
