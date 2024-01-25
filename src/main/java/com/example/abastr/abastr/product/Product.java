package com.example.abastr.abastr.product;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.abastr.abastr.order.OrderController;
import com.example.abastr.abastr.order.Order;

public class Product {

    private List<Order> destructOrdersData() {
        List<Order> productsList = new ArrayList<>();
        for (Map<String, List<Order>> products : OrderController.orders.values()) {
            for (List<Order> listItem : products.values()) {
                productsList.addAll(listItem);
            }
        }
        return productsList;
    }
    
    public static void main(String[] args) {
        List<Order> orderItems = new Product().destructOrdersData();
        Map<String, Double> avgPricePerProduct = orderItems.stream().collect(Collectors.groupingBy(Order::getProdNumber, Collectors.averagingDouble(Order::getUnitPrice)));
        for (String product : avgPricePerProduct.keySet()) {
            System.out.println(product + "\t" + avgPricePerProduct.get(product));
        }
    }
}