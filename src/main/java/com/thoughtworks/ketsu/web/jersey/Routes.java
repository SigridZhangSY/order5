package com.thoughtworks.ketsu.web.jersey;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.User;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI productUri(Product product){return URI.create("/products/" + product.getId());}

    public URI userUri(User user){return URI.create("/users/" + user.getId());}

    public URI orderUri(Order order){return URI.create("/users/" + order.getUserId() + "/orders/" + order.getId());}

}
