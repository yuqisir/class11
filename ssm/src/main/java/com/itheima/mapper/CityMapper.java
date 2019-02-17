package com.itheima.mapper;

import com.itheima.domain.City;

import java.util.List;

public interface CityMapper {
    List<City> findAll() throws Exception;
}
