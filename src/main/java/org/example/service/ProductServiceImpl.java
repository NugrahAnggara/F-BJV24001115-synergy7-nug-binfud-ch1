package org.example.service;

import org.example.Data;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService{
    @Override
    public boolean printStruct() {
        return false;
    }

    @Override
    public boolean addOrder(int quantity, String address, Product product) {
        int id = Data.dataOrder.size()+1;
        String idOrder = UUID.randomUUID().toString();
        Order order = new Order(idOrder, LocalDateTime.now(),address,Data.tempUser,false);
        OrderDetail orderDetail = new OrderDetail(id,order,product,quantity,product.getPrice()*quantity);
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
