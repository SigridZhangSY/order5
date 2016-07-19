package com.thoughtworks.ketsu.web.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidParameterException extends RuntimeException {
    private List<InvalidParameterInfo> fields;

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(Exception e) {
        super(e);
    }

    public InvalidParameterException(List<String> fieldsList){
        fields = new ArrayList<InvalidParameterInfo>();
        for(int i = 0; i < fieldsList.size(); i++)
            fields.add(new InvalidParameterInfo(fieldsList.get(i)));
    }

    public List<InvalidParameterInfo> getFields(){
        return fields;
    }
}
