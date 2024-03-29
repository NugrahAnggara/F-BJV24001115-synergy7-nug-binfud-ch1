package org.example.controller;


import org.example.model.OrderedModel;
import org.example.service.OrderServices;
import org.example.service.PaymentService;
import java.util.List;

public class OrderController
{
    private OrderServices orderServices = new OrderServices();
    private PaymentService paymentService = new PaymentService();

    public List<OrderedModel> getDataOrder()
    {
        return orderServices.getData();
    }

    public void setOrder(OrderedModel itemOrder)
    {
        orderServices.addOrder(itemOrder);
    }

    public void getStruct(List<OrderedModel> itemsOrder)
    {
        paymentService.displayStruct(itemsOrder);
    }

    public void printStruct(List<OrderedModel> itemsOrder){
        paymentService.printStruct(itemsOrder);
    }
}
