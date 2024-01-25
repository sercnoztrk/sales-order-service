package com.example.abastr.abastr.order;

//  int orderNumber, int prodNumber, int quantity, float unitPrice

public class Order {

    private String number;
    private String prodNumber;
    private int quantity;
    private double unitPrice;

    public Order() { }

    public Order(String number, String prodNumber, int quantity, double unitPrice) {
        this.number = number;
        this.prodNumber = prodNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getNumber() { return this.number; }
    public String getProdNumber() { return this.prodNumber; }
    public int getQuantity() { return this.quantity; }
    public double getUnitPrice() {return this.unitPrice; }

    public void setNumber(String n) { this.number = n; }
}