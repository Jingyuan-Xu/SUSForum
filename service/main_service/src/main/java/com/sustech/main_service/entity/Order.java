package com.sustech.main_service.entity;
import lombok.Data;
@Data
public class Order {
    Long id;
    String name = "";
    String picture = "";
    String seller = "";
    String buyer = "";
    String seller_contact = "";
    String buyer_contact = "";
    Integer price = 0;
    //0是购买者发布
    Integer status = 0;
    //0是无效
    Integer valid = 0;
    String gmt_create = "";
    String gmt_modified = "";
}