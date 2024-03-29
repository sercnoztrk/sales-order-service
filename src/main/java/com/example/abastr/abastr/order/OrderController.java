package com.example.abastr.abastr.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RestController;

import com.example.abastr.abastr.price.AveragePrice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class OrderController {
    public static LinkedHashMap<String, Map<String, List<Order>>> orders = new LinkedHashMap<>();
    static {
        Map<String, List<Order>> orderItems = new HashMap<>();        
        orderItems.put("2000", new ArrayList<>());
        orderItems.put("2001", new ArrayList<>());
        orderItems.put("2002", new ArrayList<>());
        orderItems.put("2003", new ArrayList<>());
        orderItems.put("2004", new ArrayList<>());
        
        orderItems.get("2000").add(new Order("1000", "2000", 2 , 100.51f));
        orderItems.get("2001").add(new Order("1000", "2001", 31 , 200f));
        orderItems.get("2002").add(new Order("1000", "2002", 22 , 150.86f));
        orderItems.get("2003").add(new Order("1000", "2003", 41 , 250f));
        orderItems.get("2004").add(new Order("1000", "2004", 55 , 244f));
        orders.put("1000", orderItems);
        
        orderItems = new HashMap<>();
        orderItems.put("2001", new ArrayList<>());
        orderItems.put("2002", new ArrayList<>());
        orderItems.put("2004", new ArrayList<>());
        orderItems.get("2001").add(new Order("1001", "2001", 88 , 44.531f));
        orderItems.get("2002").add(new Order("1001", "2002", 121 , 88.11f));
        orderItems.get("2002").add(new Order("1001", "2002", 14 , 88.11f));
        orderItems.get("2004").add(new Order("1001", "2004", 74 , 211f));
        orders.put("1001", orderItems);
        
        orderItems = new HashMap<>();
        orderItems.put("2003", new ArrayList<>());
        orderItems.put("2004", new ArrayList<>());
        orderItems.put("2002", new ArrayList<>());
        orderItems.put("2005", new ArrayList<>());
        orderItems.put("2006", new ArrayList<>());
        orderItems.get("2003").add(new Order("1002", "2003", 2 , 12.1f));
        orderItems.get("2003").add(new Order("1002", "2003", 8 , 12.1f));
        orderItems.get("2004").add(new Order("1002", "2004", 3 , 22.3f));
        orderItems.get("2002").add(new Order("1002", "2002", 16 , 94f));
        orderItems.get("2005").add(new Order("1002", "2005", 9 , 44.1f));
        orderItems.get("2006").add(new Order("1002", "2006", 19 , 90f));
        orders.put("1002", orderItems);
    }
    
    @GetMapping("/orders")
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
    @GetMapping("/orders/total-prices")
    public ResponseEntity<Object> getTotalPrices() {
        Map<String, Map<String, Double>> prices = new HashMap<>();
        for (String iterOrders : orders.keySet()) {
            prices.put(iterOrders, new HashMap<>());
            Map<String, List<Order>> currentOrder = orders.get(iterOrders);
            double itemTotal, orderTotal = 0;
            for (String iterProducts : currentOrder.keySet()) {
                itemTotal = 0;
                for (Order o : currentOrder.get(iterProducts)) {
                    itemTotal = itemTotal + (o.getUnitPrice() * o.getQuantity());
                }
                orderTotal = orderTotal + itemTotal;
            }
            prices.get(iterOrders).put("orderTotal", orderTotal);
        }
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
    
    @GetMapping("/orders/average-prices")
    public ResponseEntity<Object> getAveragePrices() {
        List<AveragePrice> averagePrices = new ArrayList<>();
        AveragePrice avg;
        for (String iterOrders : orders.keySet()) {
            avg = new AveragePrice();
            Map<String, List<Order>> currentOrder = orders.get(iterOrders);
            avg.setOrderNumber(iterOrders);
            int totalQuantity = 0;
            double totalPrice = 0;
            for (String iterProducts : currentOrder.keySet()) {
                for (Order o : currentOrder.get(iterProducts)) {
                    totalQuantity = totalQuantity + o.getQuantity();
                    totalPrice = totalPrice + (o.getQuantity() * o.getUnitPrice());
                }
            }
            avg.setOrderTotalPrice(totalPrice);
            avg.setOrderTotalQuantity(totalQuantity);
            avg.setOrderAveragePrice((avg.getOrderTotalPrice() / avg.getOrderTotalQuantity()));
            averagePrices.add(avg);
        }
        return new ResponseEntity<>(averagePrices, HttpStatus.OK);
    }
    
    @PostMapping("/orders")
    public ResponseEntity<Object> createOrder(@RequestBody List<Order> entity) {
        Entry<String, Map<String, List<Order>>> lastEntry;
        lastEntry = orders.entrySet().stream().reduce((one, two) -> two).get();
        int lastEntryNumber = Integer.parseInt(lastEntry.getKey());
        String newEntryNumber = Integer.toString((lastEntryNumber + 1));
        Map<String, List<Order>> orderItems = new HashMap<>();
        orders.put(newEntryNumber, orderItems);
        for (Order order : entity) {
            if(!orders.get(newEntryNumber).containsKey(order.getProdNumber())){
                orders.get(newEntryNumber).put(order.getProdNumber(), new ArrayList<>());
            }
            orders.get(newEntryNumber).get(order.getProdNumber()).add(order);
        }
        return new ResponseEntity<>("Order created!", HttpStatus.OK);
    }
    
}