package com.sustech.main_service.entity;
import lombok.Data;
@Data
public class Order {
    int id;
    String name = "";
    String picture = "";
    String seller = "";
    String buyer = "";
    String seller_contact = "";
    String buyer_contact = "";
    int price = 0;
    //0是购买者发布
    int status = 0;
    //0是无效
    int valid = 0;
    String gmt_create = "";
    String gmt_modified = "";
}