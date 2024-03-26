package org.example.service;

import org.example.entity.MenuModel;
import org.example.helper.exception.QuantityException;
import org.example.util.ValidationUtil;
import org.example.view.MenuView;

import java.util.HashMap;
import java.util.Map;

public class OrderServices implements Services {
    private Map<String, MenuModel> dataOrders = new HashMap<>();

    @Override
    public void addData(String name, int price, String key) {
        boolean trigger = false;
        do {
            int quantity = new MenuView().insertQuantity(name, price);
            try {
                new ValidationUtil().validateQuantity(quantity);
                trigger = true;
                if (dataOrders.containsKey(key)) {
                    MenuModel menuModel = dataOrders.get(key);
                    menuModel.setQuantity(quantity);
                    dataOrders.put(key, menuModel);
                } else {
                    MenuModel menu = new MenuModel(name, price);
                    menu.setQuantity(quantity);
                    dataOrders.put(key, menu);
                }

                new MenuView().displayMenu();
            } catch (QuantityException exception) {
                System.out.println(exception);
            }
        } while (!trigger);
    }

    @Override
    public Map<String, MenuModel> getData() {
        return this.dataOrders;
    }
}
