package com.itheima.service;

import com.itheima.domain.City;

import java.util.List;

public interface CityService {
    List<City> findAll() throws Exception;
}
