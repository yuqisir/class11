package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersMapper {

    List<Orders> findAll(String searchValue) throws Exception;
}
