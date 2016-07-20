package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.infrastructure.records.OrderRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public class UserResource {
    private User user;

    public UserResource(User user){
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser(){
        return user;
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Map<String, Object> info,
                                @Context Routes routes){
        List<String> invalidParameter = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            invalidParameter.add("name");
        if(info.getOrDefault("address", "").toString().trim().isEmpty())
            invalidParameter.add("address");
        if(info.getOrDefault("phone", "").toString().trim().isEmpty())
            invalidParameter.add("phone");
        if(info.getOrDefault("order_items", "").toString().trim().isEmpty())
            invalidParameter.add("order_items");
        else {
            List<Map<String, Object>> items = (List<Map<String, Object>>) info.get("order_items");
            if (items.size() == 0)
                invalidParameter.add("order_items");
            else {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getOrDefault("product_id", "").toString().trim().isEmpty())
                        invalidParameter.add("product_id");
                    if (items.get(i).getOrDefault("quantity", "").toString().trim().isEmpty())
                        invalidParameter.add("quantity");
                }
            }
        }
        if(invalidParameter.size() > 0)
            throw new InvalidParameterException(invalidParameter);
        return Response.created(routes.orderUri(user.createOrderForUser(info))).build();
    }
}
