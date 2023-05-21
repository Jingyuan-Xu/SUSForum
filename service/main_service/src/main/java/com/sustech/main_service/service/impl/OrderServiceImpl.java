package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.global.utils.DateUtils;
import com.sustech.main_service.entity.Order;
import com.sustech.main_service.mapper.OrderMapper;
import com.sustech.main_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper mapper;


    @Override
    public Result getOrderById(int id) {
        return Result.error();
    }

    @Override
    public Result getAllOrder() {
        List<Order> list = mapper.getAllOrder();
        Map<String,Object> map = new HashMap<>();
        map.put("order",list);
        return Result.ok().code(200).data(map);
    }

    @Override
    public Result buyOrder(int id,String user_id,String contact) {
        mapper.invalidOrder(id);
        mapper.setBuyer(id,user_id,contact);
        return Result.ok().code(200);
    }

    @Override
    public Result sellOrder(int id,String user_id,String contact) {
        mapper.setSeller(id,user_id,contact);
        mapper.invalidOrder(id);
        return Result.ok().code(200);
    }

    @Override
    public Result deleteOrder(int id) {
        mapper.deleteById(id);
        return Result.ok().code(200);
    }

    @Override
    public Result addOrder(String name,String picture,String publisher,boolean is_buyer,String contact,int price) {
        Order order = new Order();
        order.setName(name);
        order.setPicture(picture);
        if(is_buyer){
            order.setBuyer(publisher);
            order.setSeller("");
            order.setStatus(0);
            order.setBuyer_contact(contact);
        }else {
            order.setBuyer("");
            order.setSeller(publisher);
            order.setStatus(1);
            order.setSeller_contact(contact);
        }
        order.setValid(1);
        order.setPrice(price);
        order.setGmt_create(DateUtils.getCurrDate());
        order.setGmt_modified(DateUtils.getCurrDate());
        mapper.addOrder(order);
        return Result.ok().code(200);
    }
}
