package org.example;

import lombok.experimental.Accessors;
import org.example.entity.Merchant;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Accessors(chain = true)
public class Data {
    public static Users tempUser = new Users();
    public static List<Users> users =new ArrayList<>();
    public static List<OrderDetail> dataOrder = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();



    public void init() {

        Users user = new Users();
        user.setId(1);
        user.setUsername("nugrah");
        user.setPassword("nugrah123");
        user.setEmailAddress("nugrah@gmail.com");
        users.add(user);

        Merchant merchant1 = new Merchant();
        merchant1.setId(1);
        merchant1.setMerchantLocation("Yogyakarta");
        merchant1.setMerchantName("Rasa Nusantara Delights");
        merchant1.setOpen(true);

        Merchant merchant2 = new Merchant();
        merchant2.setId(2);
        merchant2.setMerchantLocation("Padang");
        merchant2.setMerchantName("Padang Perkasa Platter");
        merchant2.setOpen(true);

        Merchant merchant3 = new Merchant();
        merchant2.setId(3);
        merchant2.setMerchantLocation("Medan");
        merchant2.setMerchantName("Sate Seruni");
        merchant2.setOpen(false);

        Product produk1 = new Product();
        produk1.setId(1);
        produk1.setProductName("Mie Aceh");
        produk1.setPrice(15000);
        produk1.setMerchant(merchant1);
        products.add(produk1);

        Product produk2 = new Product();
        produk2.setId(2);
        produk2.setProductName("Ayam Kalio");
        produk2.setPrice(25000);
        produk2.setMerchant(merchant1);
        products.add(produk2);

        Product produk3 = new Product();
        produk3.setId(3);
        produk3.setProductName("Mie Goreng");
        produk3.setPrice(15000);
        produk3.setMerchant(merchant1);
        products.add(produk3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setProductName("Es Teh Manis");
        product4.setPrice(5000);
        product4.setMerchant(merchant1);
        products.add(product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setProductName("Es Teh Manis");
        product5.setPrice(5000);
        product5.setMerchant(merchant2);

        Product product6 = new Product();
        product6.setId(6);
        product6.setProductName("Nasi Goreng");
        product6.setPrice(12000);
        product6.setMerchant(merchant2);
        products.add(product6);


        Product product7 = new Product();
        product7.setId(7);
        product7.setProductName("Sate");
        product7.setPrice(16000);
        product7.setMerchant(merchant3);
        products.add(product7);

        Product product8 = new Product();
        product8.setId(8);
        product8.setProductName("Es Teh Manis");
        product8.setPrice(5000);
        product8.setMerchant(merchant3);
        products.add(product8);
    }
}
