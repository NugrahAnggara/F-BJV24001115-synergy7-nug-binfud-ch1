package org.example.service;

import org.example.model.OrderedModel;

import java.util.List;


public interface Services
{
    void addOrder(OrderedModel menu);

    List<OrderedModel> getData();
}
