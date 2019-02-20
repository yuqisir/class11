package com.itheima.mapper;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAll() throws Exception;

    void deleteAll(String[] ids)throws Exception;
}
