package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.User;

public class UserRecord implements User{
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
}
