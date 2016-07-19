package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.infrastructure.core.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by syzhang on 7/19/16.
 */
public interface UserMapper {
    int save(@Param("info") Map<String, Object> info);

    User findById(@Param("userId") int userId);

    User findByName(@Param("userName") String userName);
}
