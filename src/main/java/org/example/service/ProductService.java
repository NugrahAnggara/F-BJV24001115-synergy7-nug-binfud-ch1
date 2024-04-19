package org.example.service;

import org.example.entity.OrderDetail;
import org.example.entity.Product;

import java.util.List;

public interface ProductService {

    boolean printStruct();
    boolean addOrder(int quantity,String address,Product product);
    List<OrderDetail> getListOrder();

    List<Product> getProduct();


}
