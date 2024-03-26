package org.example.util;

import org.example.controller.OrderController;
import org.example.entity.MenuModel;
import org.example.helper.Helper;
import org.example.helper.exception.InputException;
import org.example.helper.exception.QuantityException;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ValidationUtil {

    OrderController orderController = new OrderController();

    public void validateQuantity(int qty) throws QuantityException {
        if (qty == 0){
            throw new QuantityException("Minimal 1 Jumlah Pesanan");
        }
    }

    public void inputValidate(String data)throws InputException{
        switch (data){
            case "1":
                orderController.setDataOrder("Nasi Goreng",15000,"1");
                break;
            case "2":
                orderController.setDataOrder("Mie Goreng",13000,"2");

                break;
            case "3":
                orderController.setDataOrder("Nasi + Ayam",18000,"3");
                break;
            case "4":
                orderController.setDataOrder("Es Teh Manis",3000,"4");
                break;
            case "5":
                orderController.setDataOrder("Es Jeruk",5000,"5");
                break;
            case "99":

            case "0":
                System.exit(0);
            default:
                String message = new String(
                        new Helper().headerMenu("Mohon masukkan input\npilihan anda")
                );
                throw new InputException(message);
        }
    }
}
