package com.sustech.main_service.service;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Order;

import java.util.List;

public interface OrderService {

    Result getOrderById(int id);

    Result getAllOrder();

    Result buyOrder(int id,String user_id,String contact);

    Result sellOrder(int id,String user_id,String contact);

    Result deleteOrder(int id);

    Result addOrder(String name,String picture,String publisher,boolean is_buyer,String contact,int price);

}
