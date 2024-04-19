package org.example.test.service;

import org.example.Data;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    private ProductServiceImpl productService;

    @BeforeEach
    void init(){
        this.productService = new ProductServiceImpl();
    }
    @Test
    void printStruct() {
        Assertions.assertEquals(true,productService.printStruct());
    }

    @Test
    void addOrder() {
        Product product = new Product(1,"Mie Ayam",12000);
        Assertions.assertEquals(true,productService.addOrder(12,"medan",product));
    }

    @Test
    void getListOrder() {
        Assertions.assertEquals(Data.dataOrder,productService.getListOrder());
    }

    @Test
    void getProduct() {
        Assertions.assertEquals(Data.products,productService.getProduct());
    }
}