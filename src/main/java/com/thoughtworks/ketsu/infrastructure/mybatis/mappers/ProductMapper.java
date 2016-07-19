package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;


import com.thoughtworks.ketsu.infrastructure.core.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    int save(@Param("info") Map<String, Object> info);

    Product findById(@Param("productId") int productId);

    List<Product> getAll();
}
