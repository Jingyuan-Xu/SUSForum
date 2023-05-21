package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into t_order(name,picture,seller,buyer,seller_contact,buyer_contact,price,status,valid,gmt_create,gmt_modified) values(#{name},#{picture},#{seller},#{buyer},#{seller_contact},#{buyer_contact},#{price},#{status},#{valid},#{gmt_create},#{gmt_modified})")
    int addOrder(Order order);

    @Select("select * from t_order")
    List<Order> getAllOrder();

    @Update("update t_order set valid=0 where id=#{id}")
    int invalidOrder(int id);

    @Update("update t_order set seller=#{seller},seller_contact=#{contact} where id=#{id}")
    int setSeller(int id,String seller,String contact);

    @Update("update t_order set buyer=#{buyer},buyer_contact=#{contact} where id=#{id}")
    int setBuyer(int id,String buyer,String contact);

    @Delete("delete from t_order where id=#{id}")
    int deleteById(int id);
}
