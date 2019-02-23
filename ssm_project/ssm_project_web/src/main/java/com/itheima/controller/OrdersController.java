package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name="pageNum",required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize,
                          @RequestParam(name="searchValue",required = false,defaultValue = "")String searchValue,Model model) throws Exception {

        List<Orders> list = ordersService.findAll(pageNum,pageSize,searchValue);
        PageInfo pageInfo=new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("sv",searchValue);
        return "orders-list";
    }

}
