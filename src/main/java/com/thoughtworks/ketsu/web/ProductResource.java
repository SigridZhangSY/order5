package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.ProductRepository;
import com.thoughtworks.ketsu.infrastructure.records.ProductRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("products")
public class ProductResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Map<String, Object> info,
                                  @Context Routes routes,
                                  @Context ProductRepository productRepository){
        List<String> invalidParameter = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            invalidParameter.add("name");
        if(info.getOrDefault("description", "").toString().trim().isEmpty())
            invalidParameter.add("description");
        if(info.getOrDefault("price", "").toString().trim().isEmpty())
            invalidParameter.add("price");
        if(invalidParameter.size() > 0)
            throw new InvalidParameterException(invalidParameter);
        return Response.created(routes.productUri(productRepository.createProduct(info))).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@Context ProductRepository productRepository){
        return productRepository.lisAllProducts();
    }

    @GET
    @Path("{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findProduct(){
        return "OK";
    }
}