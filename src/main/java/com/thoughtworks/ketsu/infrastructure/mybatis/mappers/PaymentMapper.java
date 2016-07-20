package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.infrastructure.core.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public interface PaymentMapper {
    int save(@Param("info")Map<String, Object> info);
    Payment findByOrderId(@Param("orderId") long orderId);
}
