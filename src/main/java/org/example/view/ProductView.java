package org.example.view;

import org.example.Data;
import org.example.controller.ProductController;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.util.exception.InputException;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        ProductController productController = new ProductController();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("99. Pesan Dan Bayar\n")
                .append("0. Keluar Aplikasi\n")
                .append("=> ");
        header();
        List<Product> products = productController.getData();
        listProduct(products);
        System.out.print(stringBuilder);
        String choice = scanner.next();
        try {
            productController.menuSelected(choice);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            mainMenu();
        }
    }


    void header() {
        StringBuilder strbuilder = new StringBuilder();
        strbuilder.append("\n================================\n")
                .append("Selamat Datang Di BinarFud\n")
                .append("================================\n")
                .append("\nSilahkan Pilih Makanan :");
        System.out.println(strbuilder);
    }


    public void listProduct(List<Product> products) {
        products.forEach(product -> {
            String name = product.getProductName();
            int id = product.getId();
            String status = (product.getMerchant().isOpen()) ? "Buka" : "Tutup";
            int price = product.getPrice();
            System.out.printf("%d. %-20s %-10d | %-15s\n", id, name, price, status);
        });
    }

    public void detailProduct(Product product) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n================================\n")
                .append("Berapa Pesanan Anda\n")
                .append("================================\n")
                .append(product.getProductName() + " | " + product.getPrice() + "\n")
                .append("(Input 0 untuk kembali)\n")
                .append("qty => ");

        System.out.print(stringBuilder);
        String quantity = scanner.next();
        System.out.print("Address => ");
        String address = scanner.next();
        try {
            new ProductController().addDataOrder(quantity, address, product);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            mainMenu();
        }
    }


    public void confirmAndPay() {
        int qty = 0;
        int totalPrice = 0;
        ProductController productController = new ProductController();
        List<OrderDetail> orderDetails = productController.getOrder();
        System.out.println("==================================\n" +
                "Konfirmasi Dan Bayar\n" +
                "=================================="
        );

        for (OrderDetail data : Data.dataOrder) {
            String dataDisplay = String.format("%-16s %-10d %d", data.getProduct().getProductName(), data.getQuantity(), data.getTotalPrice());
            System.out.println(dataDisplay);
            qty += data.getQuantity();
            totalPrice += data.getTotalPrice();
        }

        System.out.println("------------------------------------+");
        System.out.printf("%s %-10d %-15d", "Total", qty, totalPrice);
        System.out.println("\n1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");

        String pilihan = scanner.next();
        try {
            productController.menuSelectedPayment(pilihan);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
    }


    public void displayStruct() {
        ProductController productController = new ProductController();
        productController.printStruck();
        int qty = 0;
        int totalPrice = 0;
        System.out.println("==================================\n" +
                "BinarFud\n" +
                "=================================="
        );

        System.out.println("Terimakasih Sudah Memesan di BinarFud");
        System.out.println("Dibawah ini adalah pesanan anda");
        for (OrderDetail data : Data.dataOrder) {
            String dataDisplay = String.format("%-16s %-10d %d", data.getProduct().getProductName(), data.getQuantity(), data.getTotalPrice());
            System.out.println(dataDisplay);
            qty += data.getQuantity();
            totalPrice += data.getTotalPrice();
        }
        System.out.println("------------------------------------+");
        System.out.printf("%s %-10d %-15d", "Total", qty, totalPrice);
        System.out.println("\nPembayaran : BinarCash");
        System.out.println("==================================");
        System.out.println("Simpan Struck ini sebagai bukti pembayaran");
        System.out.println("==================================");
    }
}
