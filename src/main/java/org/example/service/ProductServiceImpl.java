package org.example.service;

import org.example.Data;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.entity.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean printStruct() {
        File file = new File("Struk Pembayaran.txt");
        try (FileWriter flw = new FileWriter(file); BufferedWriter bfw = new BufferedWriter(flw)) {
            int countQuantity = 0;
            int totalPrice = 0;

            String header = "==================================\n" +
                    "BinarFud\n" +
                    "==================================\n" +
                    "Terimakasih Sudah Memesan di BinarFud\n" +
                    "Dibawah ini adalah pesanan anda\n";

            bfw.write(header);

            for (OrderDetail data : Data.dataOrder) {
                String dataDisplay = String.format("%-16s %-10d %d", data.getProduct().getProductName(), data.getQuantity(), data.getTotalPrice());
                bfw.write(dataDisplay);
                bfw.write("\n");
                countQuantity += data.getQuantity();
                totalPrice += data.getTotalPrice();
            }

            bfw.write("\n-------------------------------+\n");
            bfw.write(String.format("%-16s %-10d %d", "Total", countQuantity, totalPrice));
            bfw.write("\n\nPembayaran : BinarCash\n");
            String footer = "==================================\n" +
                    "Simpan Struck ini sebagai bukti pembayaran\n" +
                    "==================================\n";
            bfw.write(footer);
            bfw.flush();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return true;
    }

    @Override
    public boolean addOrder(int quantity, String address, Product product) {
        int id = Data.dataOrder.size() + 1;
        String idOrder = UUID.randomUUID().toString();
        Order order = new Order(idOrder, LocalDateTime.now(), address, Data.tempUser, false);
        OrderDetail orderDetail = new OrderDetail(id, order, product, quantity, product.getPrice() * quantity);
        Data.dataOrder.add(orderDetail);
        return true;
    }

    @Override
    public List<OrderDetail> getListOrder() {
        return Data.dataOrder;
    }

    @Override
    public List<Product> getProduct() {
        return Data.products;
    }
}
