package com.example.abastr.abastr.product;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import com.example.abastr.abastr.order.OrderController;
import com.example.abastr.abastr.order.Order;

public class Product {

    private static List<Order> destructOrdersData() {
        List<Order> productsList = new ArrayList<>();
        for (Map<String, List<Order>> products : OrderController.orders.values()) {
            for (List<Order> listItem : products.values()) {
                productsList.addAll(listItem);
            }
        }
        for (Order order : productsList) {
            System.out.println(order.getNumber() + " --- " + order.getProdNumber() + " --- " + order.getQuantity() + " --- " + order.getUnitPrice());
        }
        return productsList;
    }

    private static void averagePricePerProduct(List<Order> items) {
        System.out.println("\n\n------------ Average Price Per Product --------------------");
        System.out.println("\tProduct\t\tAverage price");
        Map<String, Double> avgPricePerProduct = items.stream().collect(Collectors.groupingBy(Order::getProdNumber, Collectors.averagingDouble(Order::getUnitPrice)));
        for (String product : avgPricePerProduct.keySet()) {
            System.out.println("\t" + product + "\t\t" + avgPricePerProduct.get(product));
        }
    }
    
    private static void countsByOrder(List<Order> items) {
        System.out.println("\n\n---------------- Counts Per Order -------------------------");
        System.out.println("\tProduct\t\tOrder Number\tCount");
        Map<String, Map<String, Long>> counts = items.stream().collect(Collectors.groupingBy(Order::getProdNumber, Collectors.groupingBy(Order::getNumber, Collectors.counting())));
        for (String c1 : counts.keySet()) {
            System.out.println("\t" + c1);
            for (String c2 : counts.get(c1).keySet()) {
                System.out.println("\t\t\t" + c2 + "\t\t" + counts.get(c1).get(c2));
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
    
    public static void main(String[] args) {
        List<Order> orderItems = destructOrdersData();
        averagePricePerProduct(orderItems);
        countsByOrder(orderItems);
    }
}