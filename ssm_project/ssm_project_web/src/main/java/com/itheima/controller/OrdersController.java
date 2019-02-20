package com.itheima.controller;

import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
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
                          @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize, Model model) throws Exception {

        List<Orders> list = ordersService.findAll(pageNum,pageSize);
        model.addAttribute("ordersList",list);
        return "orders-list";
    }

}
