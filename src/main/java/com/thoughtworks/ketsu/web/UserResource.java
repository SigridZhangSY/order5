package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.infrastructure.records.OrderRecord;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response createOrder(@Context Routes routes){
        return Response.created(routes.orderUri(new OrderRecord(Long.valueOf("1"), user.getId()))).build();
    }
}
