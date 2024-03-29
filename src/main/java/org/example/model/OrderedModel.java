package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class OrderedModel {
    private int quantity;
    private int totalPrice;
    MenuModel menu;

    public OrderedModel(int quantity,int totalPrice,MenuModel menu){
        this.quantity = quantity;
        this.menu = menu;
        this.totalPrice = totalPrice;
    }
}
