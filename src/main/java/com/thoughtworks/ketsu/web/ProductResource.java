package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.records.ProductRecord;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
public class ProductResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(@Context Routes routes){
        return Response.created(routes.productUri(new ProductRecord(1))).build();
    }
}