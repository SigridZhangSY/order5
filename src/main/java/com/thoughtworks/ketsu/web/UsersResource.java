package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.infrastructure.records.UserRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("users")
public class UsersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Map<String, Object> info,
                               @Context Routes routes,
                               @Context UserRepository userRepository){
        List<String> invalidParameter = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            invalidParameter.add("name");
        if(invalidParameter.size() > 0)
            throw new InvalidParameterException(invalidParameter);
        Optional<User> user = userRepository.findUserByName(String.valueOf(info.get("name")));
        if(user.isPresent())
            throw new InvalidParameterException("user has existed");
        return Response.created(routes.userUri(userRepository.createUser(info))).build();
    }
}
