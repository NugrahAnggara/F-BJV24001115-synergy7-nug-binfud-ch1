package org.example.view;


import org.example.controller.OrderController;
import org.example.model.MenuModel;
import org.example.model.OrderedModel;
import org.example.util.Helper;
import org.example.util.InitializeMenu;
import org.example.util.ValidationUtil;
import org.example.util.exception.InputException;
import org.example.util.exception.InputNumberException;
import org.example.util.exception.QuantityException;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    private final Scanner scanner = new Scanner(System.in);
    private final OrderController orderController = new OrderController();
    private final List<OrderedModel> itemsOrder = orderController.getDataOrder();

    public void mainMenu() {
        InitializeMenu initializeMenu = new InitializeMenu();
        initializeMenu.init();

        StringBuilder header = new Helper().headerMenu("Selamat Datang Di BinarFud");
        System.out.println(header + "\nSilahkan pilih menu makanan:");

        List<MenuModel> listMenu = initializeMenu.getMenuModels();
        for (int i = 0; i < listMenu.size(); i++) {
            MenuModel itemMenu = listMenu.get(i);
            System.out.println(i + 1 + ". " + new Helper().formatString(itemMenu));
        }

        System.out.println("99. Pesan dan bayar\n" + "0. Keluar aplikasi");
        System.out.print("=> ");

        boolean triggered = true;
        while (triggered) {
            try {
                String choosingMainMenu = scanner.next();
                switch (choosingMainMenu) {
                    case "1" -> {
                        triggered = false;
                        quantityView(new MenuModel("Nasi Goreng", 15000));
                    }
                    case "2" -> {
                        triggered = false;
                        quantityView(new MenuModel("Mie Goreng", 13000));
                    }
                    case "3" -> {
                        triggered = false;
                        quantityView(new MenuModel("Nasi + Ayam", 18000));
                    }
                    case "4" -> {
                        triggered = false;
                        quantityView(new MenuModel("Es Jerung", 5000));
                    }
                    case "5" -> {
                        triggered = false;
                        quantityView(new MenuModel("Es Teh Manis", 3000));
                    }
                    case "99" -> {
                        triggered = false;

                        try {
                            if (itemsOrder.isEmpty()) {
                                throw new QuantityException(new Helper().headerMenu("Minimal 1 jumlah pesanan").toString());
                            } else {
                                menuPayment(itemsOrder);
                            }
                        } catch (QuantityException exception) {
                            System.out.println(exception.getMessage());
                            mainMenu();
                        }
                    }

                    case "0" -> {
                        triggered = false;
                        System.exit(0);
                    }
                    default ->
                            throw new InputException(new Helper().headerMenu("Mohon masukkan input anda").toString());
                }

            } catch (InputException exception) {
                System.out.println(exception.getMessage());
                String confirmInputAgain = scanner.next();
                new ValidationUtil().validateConfirm(confirmInputAgain);
            }
        }
    }

    public void quantityView(MenuModel menu) {
        System.out.println(new Helper().headerMenu("Berapa Pesanan Anda"));
        System.out.println(new Helper().formatString(menu));
        System.out.println("(input 0 untuk kembali)");
        System.out.print("qty => ");

        boolean triggered = true;
        while (triggered) {
            try {
                String input = scanner.next();
                int quantity = new Helper().parsingInteger(input);
                triggered = false;

                if (quantity == 0) {
                    mainMenu();
                } else {

                    OrderedModel itemOrder = new OrderedModel(quantity, quantity * menu.getPrice(), menu);
                    orderController.setOrder(itemOrder);
                    mainMenu();
                }

            } catch (InputNumberException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void menuPayment(List<OrderedModel> daftarItems) {
        int countQuantity = 0;
        int totalPrice = 0;
        System.out.println(new Helper().headerMenu("Konfirmasi & Pembayaran"));

        for (OrderedModel data : daftarItems) {
            String dataDisplay = String.format("%-16s %-10d %d", data.getMenu().getName(), data.getQuantity(), data.getTotalPrice());
            System.out.println(dataDisplay);
            countQuantity += data.getQuantity();
            totalPrice += data.getTotalPrice();
        }

        new Helper().dashedLine();
        new Helper().formatString("Total", countQuantity, totalPrice);

        System.out.println("\n1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");

        boolean triggered = true;
        while (triggered) {
            try {
                String option = scanner.next();
                switch (option) {
                    case "1" -> {
                        triggered = false;
                        orderController.getStruct(daftarItems);
                        orderController.printStruct(daftarItems);
                    }
                    case "2" -> mainMenu();
                    case "0" -> {
                        triggered = false;
                        System.exit(0);
                    }
                    default ->
                            throw new InputException(new Helper().headerMenu("Mohon masukkan input pilihan anda").toString());
                }
            } catch (InputException inputException) {
                System.out.println(inputException.getMessage());
            }
        }
    }
}
