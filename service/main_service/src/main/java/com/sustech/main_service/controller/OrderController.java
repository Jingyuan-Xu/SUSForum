package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Api(tags = "订单控制类")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("add")
    @ApiOperation("新增订单")
    public Result addOrder(String name, String picture, String publisher, boolean is_buyer, String contact, int price) {
        return orderService.addOrder(name, picture, publisher, is_buyer, contact, price);
    }

    @GetMapping("getAll")
    @ApiOperation("获取全部订单")
    public Result getAllOrder() {
        return orderService.getAllOrder();
    }

    @PostMapping("buy")
    @ApiOperation("为订单添加购买者")
    public Result buyOrder(int id, String user_id, String contact) {
        return orderService.buyOrder(id, user_id, contact);
    }

    @PostMapping("sell")
    @ApiOperation("为订单添加出售者")
    public Result sellOrder(int id, String user_id, String contact) {
        return orderService.sellOrder(id, user_id, contact);
    }

    @PostMapping("delete")
    @ApiOperation("删除订单")
    public Result deleteById(int id) {
        return orderService.deleteOrder(id);
    }

}
