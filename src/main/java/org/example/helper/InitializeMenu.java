package org.example.helper;

import org.example.entity.MenuModel;
import java.util.HashMap;
import java.util.Map;

public class InitializeMenu {
    Map<String, MenuModel> menu = new HashMap<>();

    public InitializeMenu(){
        menu.put("1", new MenuModel("Nasi Goreng",15000));
        menu.put("2",new MenuModel("Mie Goreng",130000));
        menu.put("3",new MenuModel("Nasi + Ayam",18000));
        menu.put("4",new MenuModel("Es Teh Manis",3000));
        menu.put("5",new MenuModel("Es Jeruk",5000));
    }

    public Map<String,MenuModel> getMenu(){
        return this.menu;
    }
}
