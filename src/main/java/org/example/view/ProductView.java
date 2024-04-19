package org.example.view;

import org.example.Data;
import org.example.controller.ProductController;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.util.exception.InputException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
                .append(product.getProductName() + " | " + product.getPrice() +"\n")
                .append("(Input 0 untuk kembali)\n")
                .append("qty => ");

        System.out.print(stringBuilder);
        String quantity = scanner.next();
        System.out.print("Address => ");
        String address = scanner.next();
        try {
            new ProductController().addDataOrder(quantity,address,product);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            mainMenu();
        }
    }
}
