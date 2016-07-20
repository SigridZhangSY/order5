package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class UserRecord implements User, Record{
    private int id;
    private String name;

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
    public Order createOrderForUser(int userId, long orderId) {
        return new OrderRecord(orderId, userId);
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
