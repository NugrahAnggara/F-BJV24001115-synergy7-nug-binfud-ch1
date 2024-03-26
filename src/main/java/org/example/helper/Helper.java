package org.example.helper;

import org.example.entity.MenuModel;

public class Helper {
    public String formatString(MenuModel menuModel){
        return String.format("%-16s | %d",menuModel.getName(),menuModel.getPrice());
    }


    public StringBuilder headerMenu(String headers){
        return new StringBuilder()
                .append("===========================\n")
                .append(headers+"\n")
                .append("===========================");
    }
}
