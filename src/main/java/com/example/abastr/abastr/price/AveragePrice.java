package com.example.abastr.abastr.price;

public class AveragePrice {
    private String orderNumber;
    private int orderTotalQuantity;
    private double orderTotalPrice;
    private double orderAveragePrice;

    public AveragePrice() {  }

    public String getOrderNumber() { return this.orderNumber; }
    public int getOrderTotalQuantity() { return this.orderTotalQuantity; }
    public double getOrderTotalPrice() { return this.orderTotalPrice; }
    public double getOrderAveragePrice() { return this.orderAveragePrice; }

    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public void setOrderTotalQuantity(int orderTotalQuantity) { this.orderTotalQuantity = orderTotalQuantity; }
    public void setOrderTotalPrice(double orderTotalPrice) { this.orderTotalPrice = orderTotalPrice; }
    public void setOrderAveragePrice(double orderAveragePrice) { this.orderAveragePrice = orderAveragePrice; }
}
