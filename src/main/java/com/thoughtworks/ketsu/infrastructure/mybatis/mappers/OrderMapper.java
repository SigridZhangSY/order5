package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public interface OrderMapper {
    int save(@Param("info") Map<String, Object> info);
    Order findById(@Param("orderId") long orderId);
    List<Order> getOrdersForUser(@Param("userId") int userId);
}
