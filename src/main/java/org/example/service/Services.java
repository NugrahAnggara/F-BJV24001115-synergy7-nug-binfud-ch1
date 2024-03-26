package org.example.service;

import org.example.entity.MenuModel;

import java.util.Map;

public interface Services {
    void addData(String name,int price,String key);
    Map<String,MenuModel> getData();
}
