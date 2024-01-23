package com.example.abastr.abastr.order;

//  int orderNumber, int prodNumber, int quantity, float unitPrice

public class Order {

    // private String orderNumber;
    private String prodNumber;
    private int quantity;
    private float unitPrice;

    public Order() { }
    public Order(String prodNumber, int quantity, float unitPrice) {
        // this.orderNumber = orderNumber;
        this.prodNumber = prodNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }


    // public String getOrderNumber() { return this.orderNumber; }
    public String getProdNumber() { return this.prodNumber; }
    public int getQuantity() { return this.quantity; }
    public float getUnitPrice() {return this.unitPrice; }
}