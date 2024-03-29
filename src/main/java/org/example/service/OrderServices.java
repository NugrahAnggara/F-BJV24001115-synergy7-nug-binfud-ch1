package org.example.service;

import org.example.model.OrderedModel;

import java.util.*;

public class OrderServices implements Services
{
    private List<OrderedModel> itemOrders = new ArrayList<>();

    @Override
    public void addOrder(OrderedModel itemOrdered)
    {
        boolean found = false;
        for (OrderedModel item : itemOrders) {
            if (item.getMenu().getName().equals(itemOrdered.getMenu().getName())) {
                int quantityNew = itemOrdered.getQuantity();
                int quantityOld = item.getQuantity();

                int totalPriceNew = itemOrdered.getTotalPrice();
                int totalPriceOld = item.getTotalPrice();
                totalPriceOld += totalPriceNew;
                quantityOld += quantityNew;

                item.setTotalPrice(totalPriceOld);
                item.setQuantity(quantityOld);
                found = true;
                break;
            }
        }

        if (!found) {
            itemOrders.add(itemOrdered);
        }
    }

    @Override
    public List<OrderedModel> getData()
    {
        return this.itemOrders;
    }


}
