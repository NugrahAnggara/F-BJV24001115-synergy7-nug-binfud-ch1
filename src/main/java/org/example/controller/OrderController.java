package org.example.controller;

import org.example.entity.MenuModel;
import org.example.service.OrderServices;

import java.util.Map;

public class OrderController {

    public Map<String, MenuModel> getDataOrder(){
        return new OrderServices().getData();
    }

    public void setDataOrder(String name,int price,String key){
        new OrderServices().addData(name,price,key);
    }
}
