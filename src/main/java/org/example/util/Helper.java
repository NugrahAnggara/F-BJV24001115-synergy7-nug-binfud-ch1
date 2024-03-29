package org.example.util;

import org.example.model.MenuModel;
import org.example.util.exception.InputNumberException;

public class Helper
{
    public String formatString(MenuModel menuModel)
    {
        return String.format("%-16s | %d", menuModel.getName(), menuModel.getPrice());
    }

    public void formatString(String title, int qty, int price)
    {
        System.out.printf("%-16s %-10d %d%n", title, qty, price);
    }

    public StringBuilder headerMenu(String headers)
    {
        return new StringBuilder()
                .append("===========================\n").append(headers).append("\n")
                .append("===========================");
    }

    public void dashedLine()
    {
        System.out.println("-------------------------------+");
    }

    public Integer parsingInteger(String input) throws InputNumberException
    {
        try {
            return Integer.parseInt(input);
        } catch (InputNumberException exception) {
            throw new InputNumberException(new Helper()
                    .headerMenu("Pastikan Menginput Jumlah Quantity")
                    .toString());
        }
    }

}
