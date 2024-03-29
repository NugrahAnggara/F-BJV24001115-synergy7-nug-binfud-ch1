package org.example.service;


import org.example.model.OrderedModel;
import org.example.util.Helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class PaymentService {
    public void displayStruct(List<OrderedModel> itemsOrder) {
        int countQuantity = 0;
        int totalPrice = 0;

        String stringBuilder = new Helper().headerMenu("BinarFud") + "\n" +
                "Terimakasih sudah memesan di BinarFud\n" +
                "Dibawah ini adalah pesanan anda\n";
        System.out.println(stringBuilder);

        for (OrderedModel data : itemsOrder) {
            String dataDisplay = String.format("%-16s %-10d %d", data.getMenu().getName(), data.getQuantity(), data.getTotalPrice());
            System.out.println(dataDisplay);
            countQuantity += data.getQuantity();
            totalPrice += data.getTotalPrice();
        }
        new Helper().dashedLine();
        new Helper().formatString("Total", countQuantity, totalPrice);
        System.out.println("\nPembayaran : BinarCash");
        System.out.println(new Helper().headerMenu("Simpan struk ini sebagai bukti pembayaran").toString());
    }

    public void printStruct(List<OrderedModel> itemsOrder) {
        File file = new File("Struk Pembayaran.txt");
        try (FileWriter flw = new FileWriter(file); BufferedWriter bfw = new BufferedWriter(flw)) {
            int countQuantity = 0;
            int totalPrice = 0;

            String header = new Helper().headerMenu("BinarFud") + "\n" +
                    "Terimakasih sudah memesan di BinarFud\n" +
                    "\nDibawah ini adalah pesanan anda\n";

            bfw.write(header);

            for (OrderedModel data : itemsOrder) {
                String dataDisplay = String.format("%-16s %-10d %d", data.getMenu().getName(), data.getQuantity(), data.getTotalPrice());
                bfw.write(dataDisplay);
                bfw.write("\n");
                countQuantity += data.getQuantity();
                totalPrice += data.getTotalPrice();
            }
            bfw.write("\n-------------------------------+\n");
            bfw.write(String.format("%-16s %-10d %d", "Total", countQuantity, totalPrice));
            bfw.write("Pembayaran : BinarCash\n");
            bfw.write(new Helper().headerMenu("Simpan struk ini sebagai bukti pembayaran").toString());
            bfw.flush();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}

