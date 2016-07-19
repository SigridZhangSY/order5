package com.thoughtworks.ketsu.web.exception;

import com.thoughtworks.ketsu.domain.Page;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by syzhang on 7/19/16.
 */
public class InvalidParameterInfo implements Record {
    private String field;
    private String message;

    public InvalidParameterInfo(String field){

        this.field = field;
        this.message = field + " can not be empty";
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("field", field);
            put("message", message);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}
