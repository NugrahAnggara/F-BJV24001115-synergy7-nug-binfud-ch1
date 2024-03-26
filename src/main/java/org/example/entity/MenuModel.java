package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class MenuModel {
    private int quantity;
    private String name;
    private int price;

    public MenuModel(String name,int price){
        this.name = name;
        this.price = price;
    }
}
