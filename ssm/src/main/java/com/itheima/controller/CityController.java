package com.itheima.controller;

import com.itheima.domain.City;
import com.itheima.domain.User;
import com.itheima.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService service;
    @RequestMapping("/findAll")
    //@RequestBody:将JSON数据转换成对象
    //@ResponseBody：将对象转换成Json
    public @ResponseBody List<City> findAll() throws Exception {
        return service.findAll();
    }
}
