package com.example.abastr.abastr.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class OrderController {
    private static Map<String, Map> orders = new HashMap<>();
    static {
        Map<String, List<Order>> orderItems = new HashMap<>();
        List<Order> productItems = new ArrayList<>();
        productItems.add(new Order("2000", 2 , 100.51f));
        orderItems.put("2000", productItems);
        productItems.clear();
        productItems.add(new Order("2001", 31 , 200f));
        orderItems.put("2001", productItems);
        productItems.clear();
        productItems.add(new Order("2002", 22 , 150.86f));
        orderItems.put("2002", productItems);
        productItems.clear();
        productItems.add(new Order("2003", 41 , 250f));
        orderItems.put("2003", productItems);
        productItems.clear();
        productItems.add(new Order("2004", 55 , 244f));
        orderItems.put("2004", productItems);
        productItems.clear();
        orders.put("1000", orderItems);
        
        orderItems.clear();
        productItems.add(new Order("2001", 88 , 44.531f));
        orderItems.put("2001", productItems);
        productItems.clear();
        productItems.add(new Order("2002", 121 , 88.11f));
        productItems.add(new Order("2002", 14 , 88.11f));
        orderItems.put("2002", productItems);
        productItems.clear();
        productItems.add(new Order("2004", 74 , 211f));
        orderItems.put("2004", productItems);
        productItems.clear();
        orders.put("1001", orderItems);

        orderItems.clear();
        productItems.add(new Order("2003", 2 , 12.1f));
        productItems.add(new Order("2003", 8 , 12.1f));
        orderItems.put("2003", productItems);
        productItems.clear();
        productItems.add(new Order("2004", 3 , 22.3f));
        orderItems.put("2004", productItems);
        productItems.clear();
        productItems.add(new Order("2002", 16 , 94f));
        orderItems.put("2002", productItems);
        productItems.clear();
        productItems.add(new Order("2005", 9 , 44.1f));
        orderItems.put("2005", productItems);
        productItems.clear();
        productItems.add(new Order("2006", 19 , 90f));
        orderItems.put("2006", productItems);
        productItems.clear();
        orders.put("1002", orderItems);
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}