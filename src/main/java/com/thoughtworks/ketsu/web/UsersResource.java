package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.records.UserRecord;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Context Routes routes){
        return Response.created(routes.userUri(new UserRecord(1))).build();
    }
}
