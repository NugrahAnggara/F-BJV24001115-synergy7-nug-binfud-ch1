package org.example;

import org.example.view.MenuView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        menuView.displayMenu();
    }
//    static Map<String,ArrayList<Integer>> dataOrder = new HashMap<>();
//    static Scanner input = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        insertMenu();
//    }
//
//    public static void insertMenu(){
//        List<List<String>> menu = new ArrayList<>();
//        menu.add(Arrays.asList("Nasi Goreng", "15000"));
//        menu.add(Arrays.asList("Mie Goreng", "13000"));
//        menu.add(Arrays.asList("Nasi + Ayam", "18000"));
//        menu.add(Arrays.asList("Es Teh Manis", "3000"));
//        menu.add(Arrays.asList("Es Jeruk", "5000"));
//
//        System.out.println("==========================");
//        System.out.println("Selamat Datang Di Binarfud");
//        System.out.println("==========================");
//
//        for (int i = 0; i < menu.size(); i++) {
//            List<String> item = menu.get(i);
//            System.out.println((i+1) + ". " + item.get(0) + " | " + item.get(1));
//        }
//        System.out.println("99. Pesan Dan Bayar");
//        System.out.println("0. Keluar Aplikasi");
//        System.out.print("=> ");
//        String chooseMenu = input.next();
//        System.out.println();
//
//        switch (chooseMenu) {
//            case "1" -> countQty("Nasi Goreng", 15000);
//            case "2" -> countQty("Mie Goreng", 13000);
//            case "3" -> countQty("Nasi + Ayam", 18000);
//            case "4" -> countQty("Es Teh Manis", 3000);
//            case "5" -> countQty("Es Jeruk", 5000);
//            case "99" -> {
//                System.out.flush();
//                orderAndPay();
//            }
//            case "0" -> System.exit(0);
//            default -> System.out.println("Pilihan tidak valid.");
//        }
//    }
//
//    public static void countQty(String menu, int price){
//
//        System.out.println("=====================");
//        System.out.println("Berapa Pesanan Anda");
//        System.out.println("=====================");
//
//        System.out.println(menu + "     | "+price);
//        System.out.println("(input 0 untuk kembali)");
//        System.out.print("=> ");
//
//        int qtyOrder = input.nextInt();
//        System.out.println();
//
//        if (qtyOrder == 0) {
//            insertMenu();
//        } else {
//            ArrayList<Integer> priceAndQty = new ArrayList<>();
//            priceAndQty.add(qtyOrder);
//            if (dataOrder.containsKey(menu)){
//                ArrayList<Integer> existingOrder = dataOrder.get(menu);
//                int existingQty = existingOrder.get(0);
//                int updatedQty = existingQty + qtyOrder;
//                existingOrder.set(0, updatedQty);
//                existingOrder.set(1, price * updatedQty);
//                dataOrder.put(menu, existingOrder);
//            } else {
//                priceAndQty.add(price * qtyOrder);
//                dataOrder.put(menu, priceAndQty);
//            }
//            insertMenu();
//        }
//    }
//
//    public static void orderAndPay(){
//        String heading = "Konfirmasi & Pembayaran";
//        int countProduct = 0;
//        int totalPrice = 0;
//        for (int i = 0; i < heading.length(); i++) System.out.print("=");
//        System.out.println("\n"+heading);
//        for (int i = 0; i < heading.length(); i++) System.out.print("=");
//        System.out.println();
//        for (String key : dataOrder.keySet()){
//            System.out.print(key + " ");
//            for (int i = 0 ; i < dataOrder.get(key).size() - 1; i++){
//                System.out.println(dataOrder.get(key).get(0)+ "  " + dataOrder.get(key).get(1));
//                countProduct += dataOrder.get(key).get(0);
//                totalPrice += dataOrder.get(key).get(1);
//            }
//        }
//
//        for (int i = 0; i < heading.length(); i++) System.out.print("-");
//        System.out.println("+");
//        System.out.println("Total " + countProduct + " " + totalPrice);
//        System.out.println();
//        System.out.println("1. Konfirmasi Dan Bayar");
//        System.out.println("2. Kembali ke menu utama");
//        System.out.println("3. Keluar Aplikasi");
//        System.out.print("=> ");
//        String chooseOptionOrder = input.next();
//
//        switch (chooseOptionOrder) {
//            case "1" -> {
//                displayStruct();
//                printStruct();
//            }
//            case "2" -> insertMenu();
//            case "3" -> System.exit(0);
//        }
//    }
//
//    public static void displayStruct(){
//        int countProduct = 0;
//        int totalPrice = 0;
//        System.out.println("=========================\nBinarFud\n=========================\n");
//        System.out.println("Terimakasih Sudah Memesan Di BinarFud");
//        System.out.println("Dibawah ini adalah pesanan anda\n");
//        for (String key : dataOrder.keySet()){
//            System.out.print(key + " ");
//            for (int i = 0 ; i < dataOrder.get(key).size() - 1; i++){
//                System.out.println(dataOrder.get(key).get(0)+ "  " + dataOrder.get(key).get(1));
//                countProduct += dataOrder.get(key).get(0);
//                totalPrice += dataOrder.get(key).get(1);
//            }
//        }
//
//        System.out.println("-----------------------+");
//        System.out.println("Total " + countProduct + " " + totalPrice);
//        System.out.print("\n");
//        System.out.println("Pembayaran : BinarCash");
//        System.out.println("=========================");
//        System.out.println("Simpan struk ini sebagai bukti pembayaran");
//        System.out.println("=========================");
//    }
//
//    public static void printStruct(){
//        try {
//            int countProduct = 0;
//            int totalPrice = 0;
//            File file = new File("Struk Pembayaran.txt");
//            FileWriter flw = new FileWriter(file);
//            BufferedWriter bfw = new BufferedWriter(flw);
//
//            bfw.write("=========================\n");
//            bfw.write("BinarFud\n");
//            bfw.write("=========================\n");
//            bfw.write("Terimakasih Sudah Memesan Di BinarFud\n");
//            bfw.write("Dibawah ini adalah pesanan anda\n");
//            for (String key : dataOrder.keySet()){
//                bfw.write(key + " ");
//                for (int i = 0 ; i < dataOrder.get(key).size() - 1; i++){
//                    bfw.write(dataOrder.get(key).get(0)+ "  " + dataOrder.get(key).get(1) +"\n");
//                    countProduct += dataOrder.get(key).get(0);
//                    totalPrice += dataOrder.get(key).get(1);
//                }
//            }
//
//            bfw.write("-----------------------+\n");
//            bfw.write("Total " + countProduct + " " + totalPrice + "\n");
//            bfw.write("Pembayaran : BinarCash\n");
//            bfw.write("=========================\n");
//            bfw.write("Simpan struk ini sebagai bukti pembayaran\n");
//            bfw.write("=========================\n");
//            bfw.flush();
//            bfw.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
