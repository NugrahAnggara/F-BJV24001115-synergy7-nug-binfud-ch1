package org.example.util;


import lombok.experimental.Accessors;
import org.example.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
public class InitializeMenu
{
    private final List<MenuModel> menuModels = new ArrayList<>();
    public void init()
    {
        menuModels.add(new MenuModel("Nasi Goreng", 15000));
        menuModels.add(new MenuModel("Mie Goreng", 13000));
        menuModels.add(new MenuModel("Nasi + Ayam", 18000));
        menuModels.add(new MenuModel("Es Jeruk", 5000));
        menuModels.add(new MenuModel("Es Teh Manis", 3000));
    }

    public List<MenuModel> getMenuModels() {
        return this.menuModels;
    }
}
