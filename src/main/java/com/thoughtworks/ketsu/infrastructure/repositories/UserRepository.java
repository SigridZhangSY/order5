package com.thoughtworks.ketsu.infrastructure.repositories;


import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements com.thoughtworks.ketsu.infrastructure.core.UserRepository{

    @Inject
    UserMapper userMapper;
    @Override
    public User createUser(Map<String, Object> info) {
        userMapper.save(info);
        return userMapper.findById(Integer.valueOf(String.valueOf(info.get("id"))));
    }

    @Override
    public Optional<User> findUserByName(String userName) {
        return Optional.ofNullable(userMapper.findByName(userName));
    }

    @Override
    public Optional<User> findUserById(int userId) {
        return Optional.ofNullable(userMapper.findById(userId));
    }
}



