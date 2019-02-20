package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(Integer pageNum,Integer pageSize,String seachValue) throws Exception;
}
